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

#config
1.遵守spring变量查找规则，首先查找环境变量的值，在查询jvm中的值，最后查找配置文件的值
  因此你可以更改配置在fig.yml(基于docker运行的时候) ,环境变量，jvm ,配置文件
  
2.配置文件在src/main/resources/spring/databases/XXX-data-access.properties
是基于spring profile, 默认是local,即使用local-data-access.properties中的配置
你可以设置 spring.profiles.active 变量来更改（在env或web.xml中）











