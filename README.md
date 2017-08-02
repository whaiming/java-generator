1、增加获取sqlServer数据库字段注释功能
2、Mapper生成接口修改：
   （1）deleteByExample接口修改为FIsDelete标志删除；
   （2）deleteByPrimaryKey接口修改为FIsDelete标志删除；
   （3）insert接口默认不生成；
   （4）updateByExample接口默认不生成；
   （5）updateByPrimaryKey接口默认不生成；
   （6）新增默认生成selectAll接口；
   （7）新增默认生成selectNotDeleteAll接口；
   （8）新增默认生成selectNotDeleteByPrimaryKey接口；
3、扩展生成Bo，可选；
4、扩展生成简单的Service和domain，可选，成对出现：
   （1）Service默认方法：save，deleteByPrimaryKey，getByPrimaryKey，getNotDeleteByPrimaryKey，findAll，findNotDeleteAll；
   （2）Domain默认方法：get;
   
   
TODO：
    1、需要优化重复生成覆盖java代码的问题；
