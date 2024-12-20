![](http://dev.lutece.paris.fr/jenkins/buildStatus/icon?job=gru-library-grubusiness-deploy)
# Librairie Grubusiness

## Introduction

Cette librairie met&nbsp;&agrave; disposition un mod&egrave;le et des services pour les objets de la GRU.

## Mod&egrave;le, interface et services

La librairie met&nbsp;&agrave; disposition des objets globaux&nbsp;&agrave; la GRU :
 
* Notification, une notification du workflow GRU
* Demand, des informations sur le ticket GRU
* Customer, des informations sur l'usager


Pour manipuler ces objets, un ensemble d'interface et de service sont pr&eacute;sents :
 
* IDemandDAO, une interface de DAO pour les Demand
* IDemandListener, une interface qui est notifi&eacute;&nbsp;&agrave; chaque op&eacute;ration sur Demand via le DemandService
* INotificationDAO, une interface de DAO pour les Notification
* INotificationListener, une interface qui est notifi&eacute;&nbsp;&agrave; chaque op&eacute;ration sur Notification via le DemandService
* DemandService, un service permettant de g&eacute;rer les Demand et les Notification
* ICustomerDAO, une interface de DAO pour les Customer
* CustomerService, un service permettant de g&eacute;rer les Customer
* IIndexingService, une interface pour les indexations


Attention cette librairie n'a pas d'impl&eacute;mentation utilisable pour ces interfaces.

## Configuration

La libraire a besoin d'avoir ces DAO et service de correctement configur&eacute; via les contexts Spring.

Le service DemandService met&nbsp;&agrave; disposition deux constructeurs. Le premier n'a besoin de recevoir que les impl&eacute;mentations des IDemandDAO et INotificationDAO. Le second a besoin des DAO ainsi que la liste des impl&eacute;mentations des IDemandListener et INotificationListener.

Le service CustomerService poss&egrave;de un unique constructeur n&eacute;cessitant l'impl&eacute;mentation d'une ICustomerDAO.

## Exemples de configuration spring

 **Configuration utilisant les objets d&eacute;finis dans le plugin plugin-notificationstore** 
```

    <bean id="notificationstore.demandDAO"  class="fr.paris.lutece.plugins.notificationstore.business.DemandDAO" />  
    <bean id="notificationstore.notificationDAO"  class="fr.paris.lutece.plugins.notificationstore.business.NotificationDAO" />
    <bean id="notificationstore.demandListener" class="fr.paris.lutece.plugins.notificationstore.business.listener.LogDemandListener" />
    <bean id="notificationstore.notificationListener" class="fr.paris.lutece.plugins.notificationstore.business.listener.LogNotificationListener" />
    <bean id="notificationstore.storageService" class="fr.paris.lutece.plugins.grubusiness.business.demand.DemandService">
      <constructor-arg ref="notificationstore.demandDAO" />
      <constructor-arg ref="notificationstore.notificationDAO" />
      <constructor-arg>
        <list>
          <ref bean="notificationstore.demandListener" />
        </list>
      </constructor-arg>
      <constructor-arg>
        <list>
          <ref bean="notificationstore.notificationListener" />
        </list>
      </constructor-arg>
    </bean>
                    
```



[Maven documentation and reports](http://dev.lutece.paris.fr/plugins/library-grubusiness/)



 *generated by [xdoc2md](https://github.com/lutece-platform/tools-maven-xdoc2md-plugin) - do not edit directly.*