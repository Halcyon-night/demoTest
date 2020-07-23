<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="margin:0 auto;">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
            <!-- 
            	该页面的class可以换选
            	<div class="modal-dialog" role="document"></div>
				<div class="modal-dialog modal-lg" role="document"></div>
				<div class="modal-dialog modal-full" role="document"></div> 
			-->
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title" id="myModalLabel">新增</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="txt_departmentname">部门名称</label>
                        <input type="text" name="txt_departmentname" class="form-control" id="txt_departmentname" placeholder="部门名称" value="">
                    </div>
                    <div class="form-group">
                        <label for="txt_parentdepartment">上级部门</label>
                        <input type="text" name="txt_parentdepartment" class="form-control" id="txt_parentdepartment" placeholder="上级部门" value="">
                    </div>
                    <div class="form-group">
                        <label for="txt_departmentlevel">部门级别</label>
                        <input type="text" name="txt_departmentlevel" class="form-control" id="txt_departmentlevel" placeholder="部门级别" value="">
                    </div>
                    <div class="form-group">
                        <label for="txt_statu">描述</label>
                        <input type="text" name="txt_statu" class="form-control" id="txt_statu" placeholder="状态" value="">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
                    <button type="button" id="btn_submit" class="btn btn-primary" data-dismiss="modal" onclick=""><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>保存</button>
                </div>
            </div>
        </div>
    </div>
