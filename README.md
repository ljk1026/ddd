# ddd脚手架
web为核心脚手架
 Application 应用服务层:实现业务适配协调领域模型完成业务功能
 
 domain层 领域层,纯业务逻辑,实现业务规则的核心代码层,不包含其他层的操作
 
 infrastructure层 基础服务层,提供资源操作例如,数据库操作,mq操作,event操作,文件操作等继承服务
 
 interface层 提供服务的访问层
 
 
 
core 为spring boot架构下的异常处理和统一返回等相关设置,未完成状态
