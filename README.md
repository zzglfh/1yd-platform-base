# 1yd-platform-base
#dir
mkdir /code/1yd-base  
cd /code/1yd-base  

# get  code
git clone git@github.com:tianjiancloud/1yd-platform-base.git

git submodule init
git submodule update

git pull

#build
mvn install

#run

fig up

# look
http://localhost:8080/1yd-base/test?name=test

#config
1.遵守spring变量查找规则，首先查找环境变量的值，在查询jvm中的值，最后查找配置文件的值
  因此你可以更改配置在fig.yml(基于docker运行的时候) ,环境变量，jvm ,配置文件
  
2.配置文件在src/main/resources/spring/databases/XXX-data-access.properties
是基于spring profile, 默认是local,即使用local-data-access.properties中的配置
你可以设置 spring.profiles.active 变量来更改（在env或web.xml中）


#开发的一些将要

#环境
ide您随便选择，但请记得一下配置
1.注释,最好使用公司统一的注释模板 见：(待定吧，哈哈)
2.编码 ,所有的文件请都采用utf-8
3.代码一行的长度，请采用120
如果不会设置的可以参考下我的一个备注：http://zzg.zgfh.xyz/eclipse-huan-jing-pei-zhi/

# 项目中添加配置
建议直接写在XXX-data-access.properties中，用apring的 @Value("${sms.username}")注入
这样我们可以通过环境变量，配置文件等进行随时改动











