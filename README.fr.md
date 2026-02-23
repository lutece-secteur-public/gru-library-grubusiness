![](https://dev.lutece.paris.fr/jenkins/buildStatus/icon?job=gru-library-grubusiness-deploy)
[![Alerte](https://dev.lutece.paris.fr/sonar/api/project_badges/measure?project=fr.paris.lutece.plugins%3Alibrary-grubusiness&metric=alert_status)](https://dev.lutece.paris.fr/sonar/dashboard?id=fr.paris.lutece.plugins%3Alibrary-grubusiness)
[![Line of code](https://dev.lutece.paris.fr/sonar/api/project_badges/measure?project=fr.paris.lutece.plugins%3Alibrary-grubusiness&metric=ncloc)](https://dev.lutece.paris.fr/sonar/dashboard?id=fr.paris.lutece.plugins%3Alibrary-grubusiness)
[![Coverage](https://dev.lutece.paris.fr/sonar/api/project_badges/measure?project=fr.paris.lutece.plugins%3Alibrary-grubusiness&metric=coverage)](https://dev.lutece.paris.fr/sonar/dashboard?id=fr.paris.lutece.plugins%3Alibrary-grubusiness)

# Plugin gru-library-grubusiness

## Introduction

La bibliothèque **gru-library-grubusiness** constitue la couche métier partagée de l'écosystème GRU (Gestion de la Relation Usager) au sein du framework Lutece. Elle ne fournit pas de plugin autonome avec son propre back-office, mais un ensemble de classes de modèle métier,d'interfaces de service, d'interfaces DAO et de classes utilitaires dont dépendent les autres plugins GRU.

La bibliothèque est organisée autour de trois domaines principaux :

 **Gestion des usagers :** La classe `Customer` modélise un citoyen avec l'ensemble de ses attributs personnels (identité, coordonnées, informations de compte). La classe `CustomerService` expose des opérations de recherche (par filtre, par nom, par identifiant) déléguées à une implémentation pluggable de `ICustomerDAO` . L'interface `ICustomerEncryptionService` permet le chiffrement et le déchiffrement transparents des données d'un usager dans le contexte d'une demande ou d'un code arbitraire.

 **Gestion des demandes :** Une `Demand` modélise une demande citoyenne avec un statut typé ( `EnumGenericStatus` : ONGOING, TOPAY, TOCOMPLETE, PAID, CLOSED, CANCELED, UNDEFINED), un identifiant de type, un identifiant de sous-type, une référence, des compteurs d'étapes, les dates de création/modification/clôture,un usager associé, des actions et des métadonnées libres. `DemandType` et `DemandCategory` permettent la classification des demandes. Un `TemporaryStatus` fait la correspondance entre des libellés de statut arbitraires et le statut générique. L'interface `IDemandServiceProvider` définit toutes les opérations du cycle de vie (création, mise à jour, suppression, recherche par usager, par référence, par filtre) et agrège l'accès aux DAOs de notifications, d'événements de notification et de statuts.Des écouteurs ( `IDemandListener` , `INotificationListener` ) permettent à d'autres composants de réagir aux événements du cycle de vie des demandes et des notifications.

 **Gestion des notifications :** Une `Notification` agrège tous les canaux de notification associés à une demande : email à l'usager ( `EmailNotification` ), SMS ( `SMSNotification` et sa variante avec compte de facturation `BillingAccountBasedSMSNotification` ), message à l'agent back-office ( `BackofficeNotification` ), notification sur le tableau de bord du citoyen ( `MyDashboardNotification` ) et emails de diffusion ( `BroadcastNotification` , avec destinataires, CC et BCC). `NotificationEvent` et `Event` permettent de journaliser les événements de distribution (succès, échec, rediffusion). Un `NotificationFilter` permet d'interroger finement les notifications par demande, usager, type et plage de dates. `ReassignNotificationsRequest` prend en charge la réaffectation de l'ensemble des notifications d'un usager vers un autre.

La bibliothèque expose également une interface générique `IIndexingService` pour l'indexation de tout objet métier, un modèle de réponse REST ( `SearchResult` , `DemandResult` , `NotificationResult` , `ResponseStatus` , `ResponseStatusFactory` ) utilisé par les API REST construites sur cette bibliothèque, ainsi que des implémentations de simulation de tous les DAOs à des fins de tests unitaires.

## Configuration

Cette bibliothèque ne fournit que des interfaces ; toutes les implémentations concrètes sont apportées par les plugins consommateurs (par exemple plugin-notificationstore, plugin-identitystore, etc.).Les beans suivants doivent être injectés par configuration Spring dans le plugin consommateur :

 **Beans à injecter via Spring (ICustomerDAO) :** Une implémentation de `fr.paris.lutece.plugins.grubusiness.business.customer.ICustomerDAO` doit être déclarée en tant que bean Spring et injectée dans `CustomerService` . Ce DAO assure le chargement des usagers par filtre, par nom ou par identifiant. Une implémentation de simulation ( `MockCustomerDAO` ) est disponible pour les tests.

 **Beans à injecter via Spring (IDemandServiceProvider) :** Une implémentation de `fr.paris.lutece.plugins.grubusiness.business.demand.IDemandServiceProvider` doit être fournie. Ce fournisseur agrège quatre interfaces DAO qui doivent également être injectées :

— `fr.paris.lutece.plugins.grubusiness.business.demand.IDemandDAO` : persistance des demandes (CRUD, filtrage, réaffectation).

— `fr.paris.lutece.plugins.grubusiness.business.demand.IDemandTypeDAO` : persistance des types de demande, avec prise en charge des métadonnées (configuration PUSH, sujet par défaut).

— `fr.paris.lutece.plugins.grubusiness.business.demand.IDemandCategoryDAO` : persistance des catégories de demande.

— `fr.paris.lutece.plugins.grubusiness.business.demand.ITemporaryStatusDAO` : persistance des statuts temporaires et de leur correspondance avec l'énumération de statuts génériques.

 **Beans à injecter via Spring (DAOs de notification) :** 

— `fr.paris.lutece.plugins.grubusiness.business.notification.INotificationDAO` : persistance des notifications avec prise en charge du filtrage, de la réaffectation et des contrôles d'existence.

— `fr.paris.lutece.plugins.grubusiness.business.notification.INotificationEventDAO` : persistance des événements de distribution de notifications avec purge par date et suppression par usager.

 **Beans optionnels :** 

— `fr.paris.lutece.plugins.grubusiness.service.encryption.ICustomerEncryptionService` : si le chiffrement des données usager est requis, une implémentation de cette interface doit être déclarée comme bean Spring.Elle fournit des méthodes `encrypt` et `decrypt` opérant sur un `Customer` dans le contexte d'une demande ou d'un code arbitraire.

— `fr.paris.lutece.plugins.grubusiness.service.notification.INotifierServiceProvider` : les implémentations de cette interface gèrent l'envoi effectif des notifications vers les systèmes externes. Plusieurs fournisseurs de notification peuvent être enregistrés, chacun déclarant les types de notificationsqu'il prend en charge via `getNotificationTypes()` .

— `fr.paris.lutece.plugins.grubusiness.business.indexing.IIndexingService` : si l'indexation des demandes ou des notifications est nécessaire, une implémentation de cette interface générique doit être fournie et câblée via Spring.

— Des beans implémentant `IDemandListener` et/ou `INotificationListener` peuvent être enregistrés via Spring pour réagir aux événements du cycle de vie des demandes et des notifications.

## Usage

 **Classes de service** 

 `fr.paris.lutece.plugins.grubusiness.business.customer.CustomerService` — Service de recherche d'usagers. Ce service délègue toute la persistance au `ICustomerDAO` injecté et expose les méthodes publiques suivantes :

— `List<Customer>findbyFilter(Map<String, String>mapFilter)` : retourne tous les usagers correspondant à la carte de filtres attribut-valeur fournie.

— `List<Customer>findbyName(String strFirstName, String strLastName)` : retourne tous les usagers correspondant au prénom et au nom donnés.

— `Customer findById(String strCustomerId)` : retourne l'usager ayant l'identifiant donné, ou `null` s'il n'est pas trouvé.

 `fr.paris.lutece.plugins.grubusiness.business.demand.IDemandServiceProvider` — Interface centrale de gestion du cycle de vie des demandes et des notifications. Les implémentations de cette interface (fournies par les plugins consommateurs) exposent le contrat public suivant :

— `Collection<Demand>findByCustomerId(String strCustomerId)` : recherche toutes les demandes d'un citoyen donné.

— `Collection<Demand>findByReference(String strReference)` : recherche toutes les demandes correspondant à une référence.

— `Demand findByPrimaryKey(String strDemandId, String strDemandTypeId, String strCustomerId)` : charge une demande unique par sa clé composite.

— `Demand create(Demand demand)` : persiste une nouvelle demande et déclenche `IDemandListener.onCreateDemand()` sur tous les écouteurs enregistrés.

— `Notification create(Notification notification)` : persiste une nouvelle notification et déclenche `INotificationListener.onCreateNotification()` .

— `NotificationEvent create(NotificationEvent notificationEvent)` : persiste un nouvel événement de distribution de notification.

— `Demand update(Demand demand)` : met à jour une demande existante et déclenche `IDemandListener.onUpdateDemand()` .

— `void updateDemandsStatusId(int nNewStatusId, int nTemporaryStatusId)` : met à jour en masse le statut de toutes les demandes liées à un statut temporaire donné.

— `void remove(String strDemandId, String strDemandTypeId, String strCustomerId)` : supprime une demande et déclenche `IDemandListener.onDeleteDemand()` et `INotificationListener.onDeleteDemand()` .

— `List<NotificationEvent>findEventsByDateAndDemandTypeIdAndStatus(...)` : recherche des événements de notification par plage de dates, type de demande et statut.

— `List<DemandType>getDemandTypesList()` : retourne la liste complète des types de demande.

— `Optional<DemandType>getDemandType(String type_id)` : retourne un type de demande par son identifiant.

— `List<Integer>getIdsByCustomerIdAndDemandTypeId(String strCustomerId, String strNotificationType, String strIdDemandType)` : retourne les identifiants de demandes filtrés par usager et type de demande.

— `Optional<TemporaryStatus>getStatusByLabel(String strStatusLabel)` : recherche un statut temporaire par libellé (correspondance partielle).

— `void deleteAllDemandByCustomerId(String strCustomerId)` : supprime toutes les demandes et données associées pour un citoyen donné (cas d'usage RGPD — droit à l'effacement).

 `fr.paris.lutece.plugins.grubusiness.service.notification.INotifierServiceProvider` — Interface de service d'envoi de notifications. Les implémentations gèrent la distribution effective des notifications vers les systèmes externes et exposent :

— `NotifyGruResponse process(Notification notification)` : traite une notification et retourne une réponse d'accusé de réception contenant le statut, les avertissements et les erreurs.

— `String getName()` : retourne le nom du fournisseur (par défaut, le nom de la classe).

— `List<EnumNotificationType>getNotificationTypes()` : déclare les canaux de notification (SMS, CUSTOMER_EMAIL, BACKOFFICE, MYDASHBOARD, BROADCAST_EMAIL) pris en charge par ce fournisseur.

 `fr.paris.lutece.plugins.grubusiness.service.encryption.ICustomerEncryptionService` — Interface de chiffrement des données usager. Expose :

— `Customer encrypt(Customer customer, Demand demand)` : retourne une copie chiffrée de l'usager dans le contexte de la demande donnée.

— `Customer encrypt(Customer customer, String strCode)` : retourne une copie chiffrée de l'usager à l'aide du code donné.

— `Customer decrypt(Customer customer, Demand demand)` : retourne une copie déchiffrée de l'usager dans le contexte de la demande donnée.

— `Customer decrypt(Customer customer, String strCode)` : retourne une copie déchiffrée de l'usager à l'aide du code donné.

 `fr.paris.lutece.plugins.grubusiness.business.indexing.IIndexingService` — Interface de service d'indexation générique. Expose :

— `void index(T object)` : indexe un objet unique.

— `void indexList(List<T>listObjects)` : indexe une liste d'objets.

— `void deleteIndex(T object)` : supprime l'entrée d'index d'un objet donné.

— `void deleteAllIndexes()` : supprime toutes les entrées d'index.

 **Énumération des statuts génériques** 

L'énumération `EnumGenericStatus` définit les statuts de demande standard utilisés sur l'ensemble de la plateforme GRU : EN_COURS (11), À_RÉGLER (12), À_COMPLÉTER (13), ACQUITTÉE (14), TERMINÉE (15), ANNULÉE (10), NON_DÉFINI (-1).Les statuts TERMINÉE, ACQUITTÉE et ANNULÉE sont marqués comme statuts finaux. Les libellés internationalisés sont définis dans `grubusiness_messages.properties` (anglais) et `grubusiness_messages_fr.properties` (français).

 **Modèle de réponse REST** 

Les classes du package `fr.paris.lutece.plugins.grubusiness.business.web.rs` fournissent une structure de réponse REST normalisée pour les plugins consommateurs : `SearchResult` (base abstraite avec statut, paginateur et nombre de résultats), `DemandResult` (liste de `DemandDisplay` ), `NotificationResult` (liste de `Notification` ), `ResponseStatus` (code HTTP + statut typé + message optionnel), et `ResponseStatusFactory` (méthodes de fabrique pour tous les codes de réponse HTTP standards : ok, success, badRequest, unauthorized, notFound, conflict, internalServerError, etc.).

 **Interfaces d'écouteurs** 

Les plugins souhaitant réagir aux événements du cycle de vie des demandes ou des notifications doivent implémenter les interfaces suivantes et les enregistrer comme beans Spring :

— `IDemandListener` : `onCreateDemand(Demand)` , `onUpdateDemand(Demand)` , `onDeleteDemand(String, String)` .

— `INotificationListener` : `onCreateNotification(Notification)` , `onUpdateNotification(Notification)` , `onDeleteDemand(String, String)` .

 **Implémentations de simulation pour les tests unitaires** 

Le package `fr.paris.lutece.plugins.grubusiness.business.mock` fournit des implémentations en mémoire de toutes les interfaces DAO et écouteur : `MockCustomerDAO` , `MockDemandDAO` , `MockNotificationDAO` , `MockNotificationEventDAO` , `MockDemandListener` , `MockNotificationListener` . Ces classes sont destinées aux tests unitaires uniquement et ne doivent pas être utilisées dans les configurations de production.


[Maven documentation and reports](https://dev.lutece.paris.fr/plugins/library-grubusiness/)



 *generated by [xdoc2md](https://github.com/lutece-platform/tools-maven-xdoc2md-plugin) - do not edit directly.*