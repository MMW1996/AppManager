<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>
                    APP 信息管理维护 <i class="fa fa-user"></i>
                    <small>${sessionScope.devUser.devname} - ${sessionScope.devUser.id}
                        - 您可以通过搜索或者其他的筛选项对APP的信息进行修改、删除等管理操作。^_^
                    </small>
                </h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <form method="post" action="<%=request.getContextPath()%>/getQueryList" id="form1" onkeydown='if(event.keyCode==13) return false;'>
                    <%--隐藏域 --%>
                    <input type="text" name="pageIdx" id="pageIdx" value="1" style="display:none"/>
                    <input type="text" name="id" id="id" value="${sessionScope.devUser.id} " style="display: none">
                    <ul>
                        <li>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">软件名称</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input name="querySoftwareName" id="querySoftwareName" type="text" class="form-control col-md-7 col-xs-12"
                                           value="${queryInfo.querySoftwareName}">
                                </div>
                            </div>
                        </li>

                        <li>
                            <div class="form-group" id="appstatus">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">APP状态</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <select name="queryStatus" id="queryStatus" class="form-control" >
                                        <option value="">--请选择--</option>
                                    </select>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="form-group" id="appplatform">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <select name="queryFlatformId" id="queryFlatformId" class="form-control" >
                                        <option value="" >--请选择--</option>
                                    </select>
                                </div>
                            </div>
                        </li>

                        <li>
                            <div class="form-group" id="levelone">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <select id="queryCategoryLevel1" name="queryCategoryLevel1" class="form-control">
                                        <option value="" >--请选择--</option>
                                    </select>
                                </div>
                            </div>
                        </li>

                        <li>
                            <div class="form-group" id="leveltwo">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="hidden" name="categorylevel2list" id="categorylevel2list"/>
                                    <select name="queryCategoryLevel2" id="queryCategoryLevel2" class="form-control">
                                        <option value="" >--请选择--</option>
                                    </select>
                                </div>
                            </div>
                        </li>

                        <li>
                            <div class="form-group" id="levelthree">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">三级分类</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <select name="queryCategoryLevel3" id="queryCategoryLevel3" class="form-control">
                                        <option value="" >--请选择--</option>
                                    </select>
                                </div>
                            </div>
                        </li>

                        <li>
                            <button id="appquery"  class="btn btn-primary"> 查 &nbsp;&nbsp;&nbsp;&nbsp;询</button>
                        </li>
                    </ul>
                </form>
            </div>
        </div>
    </div>

    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_content">
                <p class="text-muted font-13 m-b-30"></p>
                <div id="datatable-responsive_wrapper"
                     class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                    <div class="row">
                        <div class="col-sm-12">
                            <a href="${pageContext.request.contextPath}/jsp/developer/appinfoadd.jsp"
                               class="btn btn-success btn-sm">新增APP基础信息</a>
                            <table id="datatable-responsive"
                                   class="table table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed"
                                   cellspacing="0" width="100%" role="grid" aria-describedby="datatable-responsive_info"
                                   style="width: 100%;">
                                <thead>
                                <tr role="row">
                                    <th class="sorting_asc" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="First name: activate to sort column descending"
                                        aria-sort="ascending">软件名称
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        APK名称
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        软件大小(单位:M)
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        所属平台
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        所属分类(一级分类、二级分类、三级分类)
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        状态
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        下载次数
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        最新版本号
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        style="width: 124px;"
                                        aria-label="Last name: activate to sort column ascending">
                                        操作
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="appInfo" items="${pages.list}" varStatus="status">
                                    <tr role="row" class="odd" id="${appInfo.id}">
                                        <td tabindex="0" class="sorting_1">${appInfo.softwarename}</td>
                                        <td>${appInfo.apkname}</td>
                                        <td>${appInfo.softwaresize}M</td>
                                        <td>${appInfo.platformName}</td>
                                        <td>${appInfo.category}</td>
                                        <td><span id="appInfoStatus${appInfo.id}">${appInfo.statusName}</span></td>
                                        <td>${appInfo.downloads}</td>
                                        <td>${appInfo.versionNo}</td>
                                        <td name="td9">
                                            <div class="btn-group">
                                                <button type="button" class="btn dropdown-toggle btn-danger" data-toggle="dropdown">点击操作<span class="caret"></span></button>
                                                    <ul class="dropdown-menu" role="menu">
                                                        <li >
                                                            <c:choose>
                                                                <c:when test="${appInfo.status==2||appInfo.status ==5}">
                                                                    <a class="btn btn-primary btn-lg active" role="button"
                                                                       data-toggle="tooltip" data-placement="top" title=""
                                                                       appId="${appInfo.id}"
                                                                       name="updown"
                                                                       data-original-title="恭喜您，您的审核已经通过，您可以点击上架发布您的APP">上架</a>
                                                                </c:when>
                                                                <c:when test="${appInfo.status == 4}">
                                                                    <a class="btn btn-primary btn-lg active" role="button" id=""
                                                                       data-toggle="tooltip" data-placement="top" title=""
                                                                       appId="${appInfo.id}"
                                                                       name="updown"
                                                                       data-original-title="您可以点击下架来停止发布您的APP，市场将不提供APP的下载">下架</a>
                                                                </c:when>
                                                            </c:choose>
                                                        </li>
                                                        <li><a  href="<%=request.getContextPath()%>/jsp/developer/appversionadd.jsp?appId=${appInfo.id}"
                                                                class="btn btn-primary btn-lg active versionAdd" role="button" id="appAdd"
                                                               data-toggle="tooltip" data-placement="top" title=""
                                                               data-original-title="新增APP版本信息">新增版本</a>
                                                        </li>
                                                        <li><a class="btn btn-primary btn-lg active" role="button" id="versionModify"
                                                               data-toggle="tooltip" data-placement="top" title=""
                                                               data-original-title="修改APP最新版本信息">修改版本</a>
                                                        </li>
                                                       <c:if test="${appInfo.status!=2&&appInfo.status!=4}">
                                                           <li><a  href="<%=request.getContextPath()%>/getAppInfo?id=${appInfo.id}"
                                                                   class="btn btn-primary btn-lg active" role="button" id="appModify"
                                                                   data-toggle="tooltip" data-placement="top" title=""
                                                                   data-original-title="修改APP基础信息">修改</a></li>
                                                       </c:if>

                                                        <li><a class="btn btn-primary btn-lg active" role="button" id="appView"
                                                               data-placement="top" title=""
                                                               data-original-title="查看APP基础信息以及全部版本信息">查看</a></li>
                                                        <li><a
                                                                class="btn btn-primary btn-lg active delete" role="button" id="appDelete"
                                                                data-toggle="tooltip" data-placement="top" title=""
                                                                appId ="${appInfo.id}" oldPath ="${appInfo.logopicpath}"
                                                                ata-original-title="删除APP基础信息以及全部版本信息">删除</a></li>
                                                    </ul>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <%--分页模块--%>
                    <div class="row">
                        <div class="col-sm-5">
                            <div class="dataTables_info" id="datatable-responsive_info"
                                 role="status" aria-live="polite">共${pages.total}条记录
                                ${pages.pageNum}/${pages.pages}页
                            </div>
                        </div>
                        <div class="col-sm-7">
                            <div class="dataTables_paginate paging_simple_numbers"
                                 id="datatable-responsive_paginate">
                                <ul class="pagination">
                                    <c:if test="${pages.pageNum> 1}">
                                        <li class="paginate_button previous"><a
                                                href="javascript:page_nav(1);"
                                                aria-controls="datatable-responsive" data-dt-idx="0"
                                                tabindex="0">首页</a>
                                        </li>
                                        <li class="paginate_button "><a
                                                href="javascript:page_nav(${pages.pageNum-1});"
                                                aria-controls="datatable-responsive" data-dt-idx="1"
                                                tabindex="0">上一页</a>
                                        </li>
                                    </c:if>
                                    <c:if test="${pages.pageNum < pages.pages }">
                                        <li class="paginate_button "><a
                                                href="javascript:page_nav(${pages.pageNum+1 });"
                                                aria-controls="datatable-responsive" data-dt-idx="1"
                                                tabindex="0">下一页</a>
                                        </li>
                                        <li class="paginate_button next"><a
                                                href="javascript:page_nav(${pages.pages});"
                                                aria-controls="datatable-responsive" data-dt-idx="7"
                                                tabindex="0">最后一页</a>
                                        </li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                    </div>
            </div>
        </div>
    </div>
</div>
<%@include file="common/footer.jsp" %>
<script>
    $(function () {

        $("a[name='updown']").click(function(){
            //获取a标签
            var anode=$(this);
            //获取显示状态的单元格,将a标签所在的表单的单元格设置名称<td name=“td9”>
            var stateNode=$(this).parents("[name='td9']").prev().prev().prev();
            //获取app的id
            var appid=$(this).attr("appId");
            console.log(appid)
            console.log(anode.html())
            if(anode.html()=="上架"){
                //发送异步请求实现上架(4)
                $.post("<%=request.getContextPath()%>/check",{"id":appid,"status":4},function(data){
                    console.log(data.res)
                    if(data.res==1){  //成功
                        //修改显示状为"已上架"
                        stateNode.html("已上架");
                        //修改操作为下架
                        anode.html("下架");
                    }else{
                        alert("失败");
                    }
                },"json");
            }else{
                //发送异步请求完成下载(5)
                $.post("<%=request.getContextPath()%>/check",{"id":appid,"status":5},function(data){
                    console.log(data.res)
                    if(data.res==1){  //成功
                        //修改显示状为"已下架"
                        stateNode.html("已下架");
                        //修改操作为下架
                        anode.html("上架");
                    }else{
                        alert("失败");
                    }
                },"json");
            }
        });

    const status = -1;
        // 获取所有app状态信息
        getAppStatus(${queryInfo.queryStatus});
        // 获取所有app的平台信息
        getAppPlatform(${queryInfo.queryFlatformId});
        loadLevels('${queryInfo.queryCategoryLevel1}','${queryInfo.queryCategoryLevel2}','${queryInfo.queryCategoryLevel3}');
        /**
         *  当点击一级分类 ，获取该一级分类下属所有二级分类 和 三级分类
         *  并且默认各分类第一项被选中
         *  并且将此时选择的一级分类设为 selected
         *  当点击的是请选择时，列表复位
         */
        $("#queryCategoryLevel1").change(function () {
            // 获取当前选择下拉列表 value
            const id = $("#queryCategoryLevel1").val();
            // 如果点击的不是 '请选择'
            if(id!==null&&id!==''){
                // 根据id查对应二级列表和三级列表
                $.get('<%=request.getContextPath()%>/levelOneChange',{'id':id},function (data) {
                    const levelsTwo = data.levelsTwo;
                    const levelsThree = data.levelsThree;
                    // 加载levels2
                    $("#queryCategoryLevel2").empty().append('<option value="" selected>--请选择--</option>');
                    for(let i=0;i<levelsTwo.length;i++){
                        let node = '<option value=' + levelsTwo[i].id + '>' + levelsTwo[i].categoryname +'</option>'
                        $("#queryCategoryLevel2").append(node);
                    }
                    // 加载levels3
                    $("#queryCategoryLevel3").empty().append('<option value="" selected>--请选择--</option>');
                    for(let i=0;i<levelsThree.length;i++){
                        const node = '<option value=' + levelsThree[i].id + '>' + levelsThree[i].categoryname +'</option>';
                        $("#queryCategoryLevel3").append(node);
                    }
                },'json')
            }else{
                console.log("level1 点击 请选择")
                getLevelTwo('-1');
                getLevelThree();
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
        $("#queryCategoryLevel2").change(function () {
            // 对应一级分类选中
            const id = $(this).val();
            if(id!==null&&id!=='') {
                $.get('<%=request.getContextPath()%>/levelTwoChange', {'id': id}, function (data) {
                    // 一级分类设为选中
                    console.log("two: " + data.levelTwo)
                    const currentParentid = data.levelTwo.parentid;
                    $("#queryCategoryLevel1>option[value=" + currentParentid + "]").prop("selected", true);
                    // 更新三级分类
                    const levelsThree = data.levelsThree;
                    console.log("levelsThree: "+ levelsThree);
                    // 加载levels3
                    $("#queryCategoryLevel3").empty().append('<option value="">--请选择--</option>');
                    for (let i = 0; i < levelsThree.length; i++) {
                        const node = '<option value=' + levelsThree[i].id + '>' + levelsThree[i].categoryname + '</option>';
                        $("#queryCategoryLevel3").append(node);
                    }
                }, 'json')
            }else{
                getLevelTwo('-1');
                getLevelThree();
                $("#queryCategoryLevel1>option[value='']").prop("selected", true);
            }
        });
        /**
         *  三级列表改变时
         *  需要的是对应一级列表选中，并显示该一级分类下所有二级分类
         */
        $("#queryCategoryLevel3").change(function (){
            // 对应一级分类选中
            const id = $("#queryCategoryLevel3").val();
            if(id!==null&&id!=='') {
                $.get('<%=request.getContextPath()%>/levelThreeChange', {'id': id}, function (data) {
                    // 获取对应二级分类id 并设为选中状态
                    console.log("three: " + data.levelThree)
                    // 将以及列表中 id 为 currentParentid 的设为 选中
                    $("#queryCategoryLevel2>option[value=" + data.levelThree.parentid + "]").prop("selected", true);
                    // 获取对应一级分类id 并设为选中状态
                    console.log("levelOne: " + data.levelOne.id);
                    $("#queryCategoryLevel1>option[value=" + data.levelOne.id + "]").prop("selected", true);
                }, 'json')
            }else{
                getLevelTwo('-1');
                getLevelThree();
                $("#queryCategoryLevel1>option[value='']").prop("selected", true);
            }
        });
        /**
         * 增加版本
         */
        $(".addVersion").click(function () {
            const id = $(this).attr("appinfoid");
            location.href = '<%=request.getContextPath()%>/jsp/developer/appversionadd.jsp?id='+id;
        })

        /*
         * 删除appInfo
         */
        $("a[class='btn btn-primary btn-lg active delete']").click(function () {
            // 获取appId 和 logo路径
            const appId = $(this).attr("appId");
            const oldPath = $(this).attr("oldPath");
            console.log("appId="+appId);
            console.log("oldPath="+oldPath);
            if(confirm("再好好想想?")){
                $.getJSON('<%=request.getContextPath()%>/delAppInfo',{"appId":appId,"oldPath":oldPath},function (data) {
                    console.log(data)
                    if(data.res===1){
                        $("#" + appId).remove();
                    }
                })
            }
        })
    });
    /**
     * 分页
     * @param pageIdx
     */
    function page_nav(pageIdx) {
        $("#pageIdx").val(pageIdx);
        $("#form1").submit();
    }
    /**
     * 获取app状态信息
     * @param status
     */
    function getAppStatus(status) {
        // 获取所有app状态信息
        $.get('<%=request.getContextPath()%>/getAppStatus',null,function (data) {
            for(let i=0;i<data.length;i++){
                const node = '<option value=' + data[i].valueid + ' id=' + data[i].id + '>' + data[i].valuename + '</option>';
                $("#queryStatus").append(node).val(status);
            }
        },"json");
    }
    /**
     * 获取app平台信息
     * @param platform
     */
    function getAppPlatform(platform) {
        console.log(platform)
        $.get('<%=request.getContextPath()%>/getAppPlatform',null,function (data) {
            for(let i=0;i<data.length;i++){
                const node = '<option value=' + data[i].valueid + ' id=' + data[i].id + '>' + data[i].valuename + '</option>';
                $("#queryFlatformId").append(node).val(platform);
            }
        },"json");
    }

    /**
     * 获取一级分类
     */
    function getLevelOne(id1) {
        // 首先清空原下拉列表
        $("#queryCategoryLevel1>option[value!='']").remove();
        // 获取一级分类
        $.get('<%=request.getContextPath()%>/getLevelOne',null,function (data) {
            for(let i=0;i<data.length;i++){
                const node = '<option value=' + data[i].id + '  id=' + data[i].id +  '>' + data[i].categoryname +'</option>';
                $("#queryCategoryLevel1").append(node);
                if(id1!==null&&id1!==''){
                    $("#queryCategoryLevel1>option[value=" + id1 + "]").prop("selected", true);
                }
            }
        },"json");
    }
    /**
     * 获取二级分类
     */
    function getLevelTwo(id2) {
        // 首先清空原下拉列表
        $("#queryCategoryLevel2>option[value!='']").remove();
        if(id2!==null&&id2!==''&&id2!=='-1'){
            console.log('byid2='+id2)
            $.get('<%=request.getContextPath()%>/getLevelTwoById', {'id': id2}, function (data) {
                console.log('getTwoById='+data)
                // 加载levels2
                $("#queryCategoryLevel2").empty().append('<option value="">--请选择--</option>');
                for (let i = 0; i < data.length; i++) {
                    const node = '<option value=' + data[i].id + '>' + data[i].categoryname + '</option>';
                    $("#queryCategoryLevel2").append(node).val(id2);
                }
            }, 'json')
        }else{
            console.log('getTwoBy='+id2)
            // 获取二级分类
            $.get('<%=request.getContextPath()%>/getLevelTwo',null,function (data) {
                for(let i=0;i<data.length;i++){
                    const node = '<option value=' + data[i].id + ' id=' + data[i].id +  '>' + data[i].categoryname +'</option>';
                    $("#queryCategoryLevel2").append(node);

                }
            },"json");
        }

    }
    /**
     * 获取三级分类
     */
    function getLevelThree(id3) {
        // 首先清空原下拉列表
        $("#queryCategoryLevel3>option[value!='']").remove();
        if(id3!==null&&id3!==''&&id3!=='-1'){
            console.log('byid3='+id3)
            $.get('<%=request.getContextPath()%>/getLevelTwoById', {'id': id3}, function (data) {
                console.log('getTwoById='+data)
                // 加载levels3
                $("#queryCategoryLevel3").empty().append('<option value="">--请选择--</option>');
                for (let i = 0; i < data.length; i++) {
                    const node = '<option value=' + data[i].id + '>' + data[i].categoryname + '</option>';
                    $("#queryCategoryLevel3").append(node).val(id3);
                }
            }, 'json')
        }else {
            // 获取三级分类
            console.log('getThreeBy='+id3)
            $.get('<%=request.getContextPath()%>/getLevelThree', null, function (data) {
                for (let i = 0; i < data.length; i++) {
                    const node = '<option value=' + data[i].id + '  id=' + data[i].id + '>' + data[i].categoryname + '</option>';
                    $("#queryCategoryLevel3").append(node);
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

