<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>修改APP基础信息 <i class="fa fa-user"></i><small>${sessionScope.devUser.devname}</small></h2>
             <div class="clearfix"></div>
      </div>
      <div class="x_content">
        <form class="form-horizontal form-label-left" action="<%=request.getContextPath()%>/appinfomodifysave" method="post" enctype="multipart/form-data">
          <input type="hidden" value="${appInfo.id}" name="id">
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="softwareName">软件名称 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="softwareName" class="form-control col-md-7 col-xs-12" 
               data-validate-length-range="20" data-validate-words="1" 
               name="softwareName" value="${appInfo.softwarename}" required="required"
               placeholder="请输入软件名称" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="APKName">APK名称 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="APKName" type="text" class="form-control col-md-7 col-xs-12" 
              name="apkname" value="${appInfo.apkname}" >
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="supportROM">支持ROM <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="supportROM" class="form-control col-md-7 col-xs-12" 
              	name="supportrom" value="${appInfo.supportrom}" required="required"
              	data-validate-length-range="20" data-validate-words="1" 
              	placeholder="请输入支持的ROM" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="interfaceLanguage">界面语言 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="interfaceLanguage" class="form-control col-md-7 col-xs-12" 
              data-validate-length-range="20" data-validate-words="1"  required="required"
              name="interfacelanguage" value="${appInfo.interfacelanguage}"
              placeholder="请输入软件支持的界面语言" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="softwareSize">软件大小 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="number" id="softwaresize" name="softwaresize" value="${appInfo.softwaresize}" required="required"
              data-validate-minmax="10,500"  placeholder="请输入软件大小，单位为Mb" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="downloads">下载次数 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="number" id="downloads" name="downloads" value="${appInfo.downloads}" required="required"
              data-validate-minmax="10,500"  placeholder="请输入下载次数" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="fid">所属平台 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="hidden" value="${appInfo.flatformid}" id="fid" />
              <select name="flatformId" id="flatformId" class="form-control" required="required"></select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="cl1">一级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="hidden" value="${appInfo.categorylevel1}" id="cl1" />
              <select name="categorylevel1" id="categorylevel1" class="form-control"  required="required">
                <option value="">-- 请选择 --</option>
              </select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="cl2">二级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
            	<input type="hidden" value="${appInfo.categorylevel2}" id="cl2" />
              <select name="categorylevel2" id="categorylevel2" class="form-control"  required="required">
                <option value="">-- 请选择 --</option>
              </select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="cl3">三级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="hidden" value="${appInfo.categorylevel3}" id="cl3" />
              <select name="categorylevel3" id="categorylevel3" class="form-control"  required="required">
                <option value="">-- 请选择 --</option>
              </select>
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="statusName">APP状态 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="hidden" value="${appInfo.status}">
              <input id="statusName" type="text" class="form-control col-md-7 col-xs-12"
              name="statusName" value="${appInfo.statusName}" readonly="readonly">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="appInfo">应用简介 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <textarea id="appInfo" name="appInfo" required="required" placeholder="请输入本软件的相关信息，本信息作为软件的详细信息进行软件的介绍。" class="form-control col-md-7 col-xs-12">${appInfo.appinfo}</textarea>
            </div>
          </div>

           <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="attach">LOGO图片 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <c:if test="${appInfo.logolocpath!=null}">
                  <img src="${appInfo.logolocpath}" width="160" height="90"/>
                  <button>下载</button>
                </c:if>
				<div id="uploadfile" >
                <input type="hidden" name="logopicpath" value="${appInfo.logopicpath}">
                <input type="hidden" name="logolocpath" value="${appInfo.logolocpath}">
				<input id="attach"  type="file" class="form-control col-md-7 col-xs-12" name="attach">
				<p><span style="color:green;font-weight: bold;">*注：1、大小不得超过500k.2、图片格式：jpg、png、jpeg、pneg</span></p>
				</div>
				<div id="logoFile"></div>
				${fileUploadError }
            </div>
          </div>
          <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
            	<c:if test="${appInfo.status == 3}">
            	 	<button id="send" type="submit" name="status" value="1" class="btn btn-success">保存并再次提交审核</button>
            	</c:if>
              <button id="send" type="submit" class="btn btn-success">保存</button>
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
    getAppPlatform(${appInfo.flatformid})
    const level1 = ${appInfo.categorylevel1}
    const level2 = ${appInfo.categorylevel2}
    const level3 = ${appInfo.categorylevel3}
    const num = -1
    loadLevels(level1,level2,level3);
    /**
     *  当点击一级分类 ，获取该一级分类下属所有二级分类 和 三级分类
     *  并且默认各分类第一项被选中
     *  并且将此时选择的一级分类设为 selected
     *  当点击的是请选择时，列表复位
     */
    $("#categorylevel1").change(function () {
      // 获取当前选择下拉列表 value
      const id = $("#categorylevel1").val();
      // 如果点击的不是 '请选择'
      if(id!==null&&id!==''){
        // 根据id查对应二级列表和三级列表
        $.get('<%=request.getContextPath()%>/levelOneChange',{'id':id},function (data) {
          const levelsTwo = data.levelsTwo;
          const levelsThree = data.levelsThree;
          // 加载levels2
          $("#categorylevel2").empty().append('<option value="" selected>--请选择--</option>');
          for(let i=0;i<levelsTwo.length;i++){
            let node = '<option value=' + levelsTwo[i].id + '>' + levelsTwo[i].categoryname +'</option>'
            $("#categorylevel2").append(node);
          }
          // 加载levels3
          $("#categorylevel3").empty().append('<option value="" selected>--请选择--</option>');
          for(let i=0;i<levelsThree.length;i++){
            const node = '<option value=' + levelsThree[i].id + '>' + levelsThree[i].categoryname +'</option>';
            $("#categorylevel3").append(node);
          }
        },'json')
      }else{
        console.log("level1 点击 请选择")
        getLevelTwo('-1');
        getLevelThree('-1');
      }
    });
    /**
     *  当点击二级分类时，
     *  若点击的是请选择，列表复位
     *  当点击其他分类时
     *  当前二级分类所属一级分类选中
     *  同时显示所有下属三级分类
     *  并且默认三级分类中第一个被选中
     */
    $("#categorylevel2").change(function () {
      // 对应一级分类选中
      const id = $(this).val();
      if(id!==null&&id!=='') {
        $.get('<%=request.getContextPath()%>/levelTwoChange', {'id': id}, function (data) {
          // 一级分类设为选中
          console.log("two: " + data.levelTwo)
          const currentParentid = data.levelTwo.parentid;
          $("#categorylevel1>option[value=" + currentParentid + "]").prop("selected", true);
          // 更新三级分类
          const levelsThree = data.levelsThree;
          console.log("levelsThree: "+ levelsThree);
          // 加载levels3
          $("#categorylevel3").empty().append('<option value="">--请选择--</option>');
          for (let i = 0; i < levelsThree.length; i++) {
            const node = '<option value=' + levelsThree[i].id + '>' + levelsThree[i].categoryname + '</option>';
            $("#categorylevel3").append(node);
          }
        }, 'json')
      }else{
        getLevelTwo('-1');
        getLevelThree('-1');
        $("#categorylevel1>option[value='']").prop("selected", true);
      }
    });
    /**
     *  三级列表改变时
     *  需要的是对应一级列表选中，并显示该一级分类下所有二级分类
     */
    $("#categorylevel3").change(function (){
      // 对应一级分类选中
      const id = $("#categorylevel3").val();
      if(id!==null&&id!=='') {
        $.get('<%=request.getContextPath()%>/levelThreeChange', {'id': id}, function (data) {
          // 获取对应二级分类id 并设为选中状态
          console.log("three: " + data.levelThree)
          // 将以及列表中 id 为 currentParentid 的设为 选中
          $("#categorylevel2>option[value=" + data.levelThree.parentid + "]").prop("selected", true);
          // 获取对应一级分类id 并设为选中状态
          console.log("levelOne: " + data.levelOne.id);
          $("#categorylevel1>option[value=" + data.levelOne.id + "]").prop("selected", true);
        }, 'json')
      }else{
        getLevelTwo('-1');
        getLevelThree('-1');
        $("#categorylevel1>option[value='']").prop("selected", true);
      }
    });



  })
  /**
   * 获取app平台信息
   * @param platform
   */
  function getAppPlatform(platform) {
    console.log(platform)
    $.get('<%=request.getContextPath()%>/getAppPlatform',null,function (data) {
      for(let i=0;i<data.length;i++){
        const node = '<option value=' + data[i].valueid + ' id=' + data[i].id + '>' + data[i].valuename + '</option>';
        $("#flatformId").append(node).val(platform);
      }
    },"json");
  }

  /**
   * 获取一级分类
   */
  function getLevelOne(id1) {
    // 首先清空原下拉列表
    $("#categorylevel1>option[value!='']").remove();
    // 获取一级分类
    $.get('<%=request.getContextPath()%>/getLevelOne',null,function (data) {
      for(let i=0;i<data.length;i++){
        const node = '<option value=' + data[i].id + '  id=' + data[i].id +  '>' + data[i].categoryname +'</option>';
        $("#categorylevel1").append(node);
        if(id1!==null&&id1!==''){
          $("#categorylevel1>option[value=" + id1 + "]").prop("selected", true);
        }
      }
    },"json");
  }
  /**
   * 获取二级分类
   */
  function getLevelTwo(id2) {
    // 首先清空原下拉列表
    $("#categorylevel2>option[value!='']").remove();
    if(id2!==null&&id2!==''&&id2!=='-1'){
      console.log('byid2='+id2)
      $.get('<%=request.getContextPath()%>/getLevelTwoById', {'id': id2}, function (data) {
        console.log('getTwoById='+data)
        // 加载levels2
        $("#categorylevel2").empty().append('<option value="">--请选择--</option>');
        for (let i = 0; i < data.length; i++) {
          const node = '<option value=' + data[i].id + '>' + data[i].categoryname + '</option>';
          $("#categorylevel2").append(node).val(id2);
        }
      }, 'json')
    }else{
      console.log('getTwoBy='+id2)
      // 获取二级分类
      $.get('<%=request.getContextPath()%>/getLevelTwo',null,function (data) {
        for(let i=0;i<data.length;i++){
          const node = '<option value=' + data[i].id + ' id=' + data[i].id +  '>' + data[i].categoryname +'</option>';
          $("#categorylevel2").append(node);

        }
      },"json");
    }

  }
  /**
   * 获取三级分类
   */
  function getLevelThree(id3) {
    // 首先清空原下拉列表
    $("#categorylevel3>option[value!='']").remove();
    if(id3!==null&&id3!==''&&id3!=='-1'){
      console.log('byid3='+id3)
      $.get('<%=request.getContextPath()%>/getLevelTwoById', {'id': id3}, function (data) {
        console.log('getTwoById='+data)
        // 加载levels3
        $("#categorylevel3").empty().append('<option value="">--请选择--</option>');
        for (let i = 0; i < data.length; i++) {
          const node = '<option value=' + data[i].id + '>' + data[i].categoryname + '</option>';
          $("#categorylevel3").append(node).val(id3);
        }
      }, 'json')
    }else {
      // 获取三级分类
      console.log('getThreeBy='+id3)
      $.get('<%=request.getContextPath()%>/getLevelThree', null, function (data) {
        for (let i = 0; i < data.length; i++) {
          const node = '<option value=' + data[i].id + '  id=' + data[i].id + '>' + data[i].categoryname + '</option>';
          $("#categorylevel3").append(node);
        }
      }, "json")
    }
  }
  function loadLevels(id1,id2,id3) {
    getLevelOne(id1);
    getLevelTwo(id2);
    getLevelThree(id3);
  }

</script>