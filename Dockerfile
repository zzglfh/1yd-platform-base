FROM w1yd/tomcat:7-jdk7

MAINTAINER Yann "yann@tianjiancloud.com"

RUN echo "Asia/Shanghai" > /etc/timezone && \
        dpkg-reconfigure -f noninteractive tzdata

RUN rm -r /usr/local/tomcat/webapps/*
ADD target/ROOT.war /usr/local/tomcat/webapps/ROOT.war

# Start Tomcat
CMD ["catalina.sh", "run"]