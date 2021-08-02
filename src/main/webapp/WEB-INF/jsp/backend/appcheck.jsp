<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>查看并审核APP信息 <i class="fa fa-user"></i><small>${sessionScope.backenduser.username}</small></h2>
             <div class="clearfix"></div>
      </div>
      <div class="x_title">
            <h2>APP基础信息</h2>
          <div class="clearfix"></div>
      </div>
      <div class="x_content1">
        <form class="form-horizontal form-label-left" action="<%=request.getContextPath()%>/check" method="post">
          <input type="hidden" name="id" value="${appInfo.id}">
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="softwarename">软件名称 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input class="form-control col-md-7 col-xs-12" value="${appInfo.softwarename}"
              type="text" readonly="readonly" id="softwarename">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="apkname">APK名称 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="text" class="form-control col-md-7 col-xs-12" id="apkname"
              value="${appInfo.apkname}" readonly="readonly">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="supportrom">支持ROM <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input class="form-control col-md-7 col-xs-12"  id="supportrom"
              	value="${appInfo.supportrom}" type="text" readonly="readonly">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="interfacelanguage">界面语言 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input class="form-control col-md-7 col-xs-12" readonly="readonly" id="interfacelanguage"
              	value="${appInfo.interfacelanguage}" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="softwaresize">软件大小 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="text" value="${appInfo.softwaresize}" id="softwaresize"
              class="form-control col-md-7 col-xs-12" readonly="readonly">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="downloads">下载次数 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="text" value="${appInfo.downloads}" id="downloads"
               class="form-control col-md-7 col-xs-12" readonly="readonly">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="platformName">所属平台 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="text" class="form-control col-md-7 col-xs-12"  id="platformName"
              	value="${appInfo.platformName}" readonly="readonly">
            
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="category">所属分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="text" class="form-control col-md-7 col-xs-12"  id="category"
              	value="${appInfo.category}" readonly="readonly">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="statusName">APP状态 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
            	<input type="text" class="form-control col-md-7 col-xs-12"  id="statusName"
              	value="${appInfo.statusName}" readonly="readonly">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="appinfo">应用简介 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <textarea class="form-control col-md-7 col-xs-12" readonly="readonly" id="appinfo">${appInfo.appinfo}</textarea>
            </div>
          </div>
           <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="logo">LOGO图片 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12" id="logo">
			 <c:choose> 
				  <c:when test="${appInfo.logolocpath == null || appInfo.logolocpath == ''}">
				    	暂无
				  </c:when> 
				  <c:otherwise>   
				    <img src="${appInfo.logolocpath}" width="100px;" height="80px;"/>
                    <a href="${appInfo.logolocpath}">下载</a>
                    <a href="#">查看大图</a>
				  </c:otherwise> 
              </c:choose> 
            </div>
          </div>
        	<div class="form-group">
        		<div class="col-md-6 col-md-offset-3">
                <%-- 多提交按钮区分操作,name一样即可 --%>
        		<button id="pass" type="submit" name="status" value="2" class="btn btn-success">审核通过</button>
        		<button id="fail" type="submit" name="status" value="3" class="btn btn-success">审核不通过</button>
          		<button type="button" class="btn btn-primary" id="back">返回</button>
        		</div>
     		</div>
        </form>
        </div>
        <div class="clearfix"></div>
        <div class="x_title">
            <h2>最新版本信息</h2>
            <ul class="nav navbar-right panel_toolbox">
              <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
              </li>
            </ul>
          <div class="clearfix"></div>
        </div>
        <div class="x_content" style="display: block;">
         <br>
        <form class="form-horizontal form-label-left">
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="versionno">版本号 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input class="form-control col-md-7 col-xs-12" id="versionno" value="${appVersion.versionno }"
              type="text" readonly="readonly" >
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="versionsize">版本大小 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="number" id="versionsize" value="${appVersion.versionsize }" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
       
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="publishStatus">发布状态 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="hidden" name="publishStatus" id="publishStatus" value="3">预发布
            </div>
          </div>
        
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="versioninfo">版本简介<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <textarea class="form-control col-md-7 col-xs-12" id="versioninfo">${appVersion.versioninfo }</textarea>
            </div>
          </div>
           <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="apkfile">apk文件 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12" id="apkfile">
            <c:choose> 
			  <c:when test="${appVersion.downloadlink == null || appVersion.downloadlink == ''}">
			    	暂无
			  </c:when> 
			  <c:otherwise>   
			    <p>
                    ${appVersion.apkfilename}&nbsp;&nbsp;
			    <a href="<%=request.getContextPath()%>/apkDownload?link=${appVersion.apklocpath}" >下载</a>
			    </p>
			  </c:otherwise> 
            </c:choose> 
            </div>
          </div>
          <div class="clearfix"></div>
          <br/><br/>
        </form>
    </div>
    <div class="clearfix"></div>
    <br/><br/>
  </div>
</div>
<%@include file="common/footer.jsp"%>
  <script>
    $(function (){
      $("#back").click(function () {
          location.href = "<%=request.getContextPath()%>/jsp/backend/applist.jsp";
      })
    })
  </script>