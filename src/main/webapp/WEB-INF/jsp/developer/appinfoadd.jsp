<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>新增APP基础信息 <i class="fa fa-user"></i><small>${sessionScope.devUser.devname}</small></h2>
             <div class="clearfix"></div>
      </div>
      <div class="x_content">
          <div class="item form-group">
               <label class="control-label col-md-3 col-sm-3 col-xs-12" ></label>
               <div class="col-md-6 col-sm-6 col-xs-12">
                 <form action="uploadlogo" class="dropzone" style="height:100px;">
                 </form>
            <div class="clearfix"></div>
         </div>
       </div>
           <div class="clearfix"></div>
        <form class="form-horizontal form-label-left" id="form1" action="<%=request.getContextPath()%>/appInfoAdd" method="post" enctype="multipart/form-data">
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="softwareName">软件名称 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="softwarename" class="form-control col-md-7 col-xs-12"
               data-validate-length-range="20" data-validate-words="1" name="softwarename"  required="required"
               placeholder="请输入软件名称" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="apkname">APK名称 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="apkname" class="form-control col-md-7 col-xs-12"
              	data-validate-length-range="20" data-validate-words="1" name="apkname"   required="required"
              	placeholder="请输入APK名称" type="text">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="supportrom">支持ROM <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="supportrom" class="form-control col-md-7 col-xs-12" name="supportrom"
              	data-validate-length-range="20" data-validate-words="1"   required="required"
              	placeholder="请输入支持的ROM" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="interfacelanguage">界面语言 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="interfacelanguage" class="form-control col-md-7 col-xs-12"
              data-validate-length-range="20" data-validate-words="1" name="interfacelanguage"   required="required"
              placeholder="请输入软件支持的界面语言" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="softwaresize">软件大小 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="number" id="softwaresize" name="softwaresize" min="1"   required="required" onkeyup="value=value.replace(/[^\d]/g,'')"
              data-validate-minmax="10,500"  placeholder="请输入软件大小，单位为Mb" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="downloads">下载次数 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="number" id="downloads" name="downloads"   required="required" min="0"
              data-validate-minmax="10,500"  placeholder="请输入下载次数" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="flatformid">所属平台 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="flatformid" id="flatformid" class="form-control"   required="required"></select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="categorylevel1">一级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="categorylevel1" id="categorylevel1" class="form-control"   required="required">
                  <option value="">-- 请选择 --</option>
              </select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="categorylevel2">二级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="categorylevel2" id="categorylevel2" class="form-control"  required="required">
                  <option value="">-- 请选择 --</option>
              </select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="categorylevel3">三级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="categorylevel3" id="categorylevel3" class="form-control"  required="required">
                  <option value="">-- 请选择 --</option>
              </select>
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="status">APP状态 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
            	<input type="hidden" name="status" id="status" value="1">待审核
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="appinfo">应用简介 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <textarea id="appinfo" name="appinfo"     required="required"
              placeholder="请输入本软件的相关信息，本信息作为软件的详细信息进行软件的介绍。" class="form-control col-md-7 col-xs-12"></textarea>
            </div>
          </div>
           <div class="item form-group">
             <%--文件保存在FTP文件服务器 文件域name不能与实体属性名相同 --%>
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="a_logoPicPath">LOGO图片 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
            <input type="file" class="form-control col-md-7 col-xs-12" name="a_logoPicPath"  required="required" id="a_logoPicPath"/>
            ${fileUploadError}
            </div>
          </div>
          <div class="ln_solid"></div>
          <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
              <button id="send" <%--type="submit"--%> class="btn btn-success">保存</button>
              <button type="button" class="btn btn-primary" id="back">返回</button>
              <br/><br/>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<%@include file="common/footer.jsp"%>
<script>
  $(function () {
      getLevelOne();
      getAppPlatform();

      // 返回
      $("#back").click(function () {
          location.href = 'appinfolist.jsp';
      })

      // 一级分类改变获取二级分类
      $("#categorylevel1").change(function () {
          if($(this).val()===''){
              // 当选择 请选择 时 清空level2 level3
              $("#categorylevel2>option[value!='']").remove();
              $("#categorylevel3>option[value!='']").remove();
          }else{
              console.log($(this).val())
              getLevelTwo($(this).val());
          }
      });

      // level2 改变获取三级分类
      $("#categorylevel2").change(function () {
          if($(this).val()===''){
              // 当选择 请选择 时 清空level3
              $("#categorylevel3>option[value!='']").remove();
          }else{
              console.log($(this).val());
              getLevelThree($(this).val());
          }
      });


      $("#send").click(function () {
          if($("#categorylevel1").val()===''||$("#categorylevel2").val()===''||$("#categorylevel3").val()===''){
              alert('请选择分类')
          }else{
              $("#form1").submit();
          }
      })
  });


  function getAppPlatform() {
      $.get('<%=request.getContextPath()%>/getAppPlatform',null,function (data) {
          for(let i=0;i<data.length;i++){
              const node = '<option value=' + data[i].valueid + ' id=' + data[i].id + '>' + data[i].valuename + '</option>';
              $("#flatformid").append(node);
          }
      },"json");
  }
  function getLevelOne() {
      // 获取一级分类
      $.get('<%=request.getContextPath()%>/getLevelOne',null,function (data) {
          for(let i=0;i<data.length;i++){
              // 循环拼接子节点
              const node = '<option value=' + data[i].id + '  id=' + data[i].id +  ' >' + data[i].categoryname +'</option>'
              $("#categorylevel1").append(node);
          }
      },"json");
  }
  function getLevelTwo(id) {
      // 获取二级分类
      $("#categorylevel2>option[value!='']").remove();
      $.get('<%=request.getContextPath()%>/getLevelTwo',null,function(data) {
          for(let i=0;i<data.length;i++){
              // 循环拼接子节点
              if(data[i].parentid==id) {
                  const node = '<option value=' + data[i].id + '  id=' + data[i].id + ' >' + data[i].categoryname + '</option>';
                  $("#categorylevel2").append(node);
              }
          }
      },"json");
  }
  function getLevelThree(id) {
      // 获取三级分类
      $("#categorylevel3>option[value!='']").remove();
      $.get('<%=request.getContextPath()%>/getLevelThree',null,function (data) {
          for(let i=0;i<data.length;i++){
              // 循环拼接子节点
              if(data[i].parentid==id) {
                  const node = '<option value=' + data[i].id + '  id=' + data[i].id + ' >' + data[i].categoryname + '</option>';
                  $("#categorylevel3").append(node);
              }
          }
      },"json");
  }

</script>