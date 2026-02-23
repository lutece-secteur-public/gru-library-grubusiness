![](https://dev.lutece.paris.fr/jenkins/buildStatus/icon?job=gru-library-grubusiness-deploy)
[![Alerte](https://dev.lutece.paris.fr/sonar/api/project_badges/measure?project=fr.paris.lutece.plugins%3Alibrary-grubusiness&metric=alert_status)](https://dev.lutece.paris.fr/sonar/dashboard?id=fr.paris.lutece.plugins%3Alibrary-grubusiness)
[![Line of code](https://dev.lutece.paris.fr/sonar/api/project_badges/measure?project=fr.paris.lutece.plugins%3Alibrary-grubusiness&metric=ncloc)](https://dev.lutece.paris.fr/sonar/dashboard?id=fr.paris.lutece.plugins%3Alibrary-grubusiness)
[![Coverage](https://dev.lutece.paris.fr/sonar/api/project_badges/measure?project=fr.paris.lutece.plugins%3Alibrary-grubusiness&metric=coverage)](https://dev.lutece.paris.fr/sonar/dashboard?id=fr.paris.lutece.plugins%3Alibrary-grubusiness)

# Plugin gru-library-grubusiness

## Introduction

The **gru-library-grubusiness** library is a shared business layer for the GRU (Gestion de la Relation Usager — Citizen Relationship Management) ecosystem in the Lutece framework. It does not provide a standalone plugin with its own back-office, but rather a set of business model classes,service interfaces, DAO interfaces, and utility classes that other GRU plugins depend upon.

The library is structured around three main domains:

 **Customer management:** The `Customer` class models a citizen with all personal attributes (identity, contact details, account information). The `CustomerService` class exposes search operations (by filter, by name, by identifier) delegated to a pluggable `ICustomerDAO` . An `ICustomerEncryptionService` interface allows transparent encryption and decryption of customer data in the context of a given demand or an arbitrary code.

 **Demand management:** A `Demand` models a citizen request with typed status ( `EnumGenericStatus` : ONGOING, TOPAY, TOCOMPLETE, PAID, CLOSED, CANCELED, UNDEFINED), a type identifier, a sub-type identifier, a reference, step counters, creation/modification/closure dates, a linked customer, actions and free-form metadata. `DemandType` and `DemandCategory` allow classification of demands. A `TemporaryStatus` entity maps arbitrary status labels to a generic status. The `IDemandServiceProvider` interface defines all lifecycle operations (create, update, delete, search by customer, by reference, by filter) and aggregates access to notification, notification-event and status DAOs.Listeners ( `IDemandListener` , `INotificationListener` ) allow other components to react to demand and notification lifecycle events.

 **Notification management:** A `Notification` aggregates all the different notification channels associated with a demand: email to the customer ( `EmailNotification` ), SMS ( `SMSNotification` and its billing-account variant `BillingAccountBasedSMSNotification` ), back-office agent message ( `BackofficeNotification` ), citizen dashboard notification ( `MyDashboardNotification` ), and broadcast emails ( `BroadcastNotification` , supporting recipients, CC and BCC). `NotificationEvent` and `Event` allow logging of delivery events (success, failure, redelivery). A `NotificationFilter` allows fine-grained querying of notifications by demand, customer, type and date range. `ReassignNotificationsRequest` supports the reassignment of all notifications from one customer to another.

The library also exposes a generic `IIndexingService` interface for indexing any business object, a REST response model ( `SearchResult` , `DemandResult` , `NotificationResult` , `ResponseStatus` , `ResponseStatusFactory` ) used by REST APIs built on top of this library, and mock implementations of all DAOs for unit testing purposes.

## Configuration

This library provides only interfaces; all concrete implementations are provided by dependent plugins (e.g. plugin-notificationstore, plugin-identitystore, etc.). The following beans must be injected by Spring configuration in the consuming plugin:

 **Beans to inject via Spring (ICustomerDAO):** An implementation of `fr.paris.lutece.plugins.grubusiness.business.customer.ICustomerDAO` must be declared as a Spring bean and injected into `CustomerService` . This DAO is responsible for loading customers by filter, by name, or by identifier. A mock implementation ( `MockCustomerDAO` ) is available for testing.

 **Beans to inject via Spring (IDemandServiceProvider):** An implementation of `fr.paris.lutece.plugins.grubusiness.business.demand.IDemandServiceProvider` must be provided. This provider aggregates four DAO interfaces that must also be injected:

— `fr.paris.lutece.plugins.grubusiness.business.demand.IDemandDAO` : persistence of demands (CRUD, filtering, reassignment).

— `fr.paris.lutece.plugins.grubusiness.business.demand.IDemandTypeDAO` : persistence of demand types, with support for metadata (PUSH configuration, default subject).

— `fr.paris.lutece.plugins.grubusiness.business.demand.IDemandCategoryDAO` : persistence of demand categories.

— `fr.paris.lutece.plugins.grubusiness.business.demand.ITemporaryStatusDAO` : persistence of temporary status entries and their mapping to the generic status enumeration.

 **Beans to inject via Spring (Notification DAOs):** 

— `fr.paris.lutece.plugins.grubusiness.business.notification.INotificationDAO` : persistence of notifications with support for filtering, reassignment and existence checks.

— `fr.paris.lutece.plugins.grubusiness.business.notification.INotificationEventDAO` : persistence of notification delivery events with date-based purge and customer-based deletion.

 **Optional beans:** 

— `fr.paris.lutece.plugins.grubusiness.service.encryption.ICustomerEncryptionService` : if customer data encryption is required, an implementation of this interface should be declared as a Spring bean. It provides `encrypt` and `decrypt` methods operating on a `Customer` in the context of a demand or an arbitrary code string.

— `fr.paris.lutece.plugins.grubusiness.service.notification.INotifierServiceProvider` : implementations of this interface handle the actual dispatch of notifications to external channels (email gateway, SMS gateway, etc.). Multiple notifier providers can be registered, each declaring the notification types they manage via `getNotificationTypes()` .

— `fr.paris.lutece.plugins.grubusiness.business.indexing.IIndexingService` : if search indexing of demands or notifications is needed, an implementation of this generic interfacemust be provided and wired via Spring.

— Listener beans implementing `IDemandListener` and/or `INotificationListener` can be registered via Spring to react to lifecycle events on demands and notifications.

## Usage

 **Service classes** 

 `fr.paris.lutece.plugins.grubusiness.business.customer.CustomerService` — Customer search service. This service delegates all persistence to the injected `ICustomerDAO` and exposes the following public methods:

— `List<Customer>findbyFilter(Map<String, String>mapFilter)` : returns all customers matching the given attribute-value filter map.

— `List<Customer>findbyName(String strFirstName, String strLastName)` : returns all customers matching the given first and last name.

— `Customer findById(String strCustomerId)` : returns the customer with the given identifier, or `null` if not found.

 `fr.paris.lutece.plugins.grubusiness.business.demand.IDemandServiceProvider` — Core demand and notification lifecycle interface. Implementations of this interface (provided by dependent plugins) expose the following public contract:

— `Collection<Demand>findByCustomerId(String strCustomerId)` : finds all demands for a given citizen.

— `Collection<Demand>findByReference(String strReference)` : finds all demands matching a reference.

— `Demand findByPrimaryKey(String strDemandId, String strDemandTypeId, String strCustomerId)` : loads a single demand by its composite key.

— `Demand create(Demand demand)` : persists a new demand and fires `IDemandListener.onCreateDemand()` on all registered listeners.

— `Notification create(Notification notification)` : persists a new notification and fires `INotificationListener.onCreateNotification()` .

— `NotificationEvent create(NotificationEvent notificationEvent)` : persists a new notification delivery event.

— `Demand update(Demand demand)` : updates an existing demand and fires `IDemandListener.onUpdateDemand()` .

— `void updateDemandsStatusId(int nNewStatusId, int nTemporaryStatusId)` : bulk-updates the status of all demands linked to a given temporary status.

— `void remove(String strDemandId, String strDemandTypeId, String strCustomerId)` : deletes a demand and fires `IDemandListener.onDeleteDemand()` and `INotificationListener.onDeleteDemand()` .

— `List<NotificationEvent>findEventsByDateAndDemandTypeIdAndStatus(...)` : searches notification events by date range, demand type and status.

— `List<DemandType>getDemandTypesList()` : returns the full list of demand types.

— `Optional<DemandType>getDemandType(String type_id)` : returns a demand type by its type identifier.

— `List<Integer>getIdsByCustomerIdAndDemandTypeId(String strCustomerId, String strNotificationType, String strIdDemandType)` : returns demand identifiers filtered by customer and demand type.

— `Optional<TemporaryStatus>getStatusByLabel(String strStatusLabel)` : finds a temporary status by label (partial match).

— `void deleteAllDemandByCustomerId(String strCustomerId)` : deletes all demands and associated data for a given citizen (GDPR erasure use-case).

 `fr.paris.lutece.plugins.grubusiness.service.notification.INotifierServiceProvider` — Notification dispatch service interface. Implementations handle the actual delivery of notifications to external systems and expose:

— `NotifyGruResponse process(Notification notification)` : processes a notification and returns an acknowledgement response containing status, warnings and errors.

— `String getName()` : returns the provider's name (defaults to the class name).

— `List<EnumNotificationType>getNotificationTypes()` : declares which notification channels (SMS, CUSTOMER_EMAIL, BACKOFFICE, MYDASHBOARD, BROADCAST_EMAIL) this provider handles.

 `fr.paris.lutece.plugins.grubusiness.service.encryption.ICustomerEncryptionService` — Customer data encryption interface. Exposes:

— `Customer encrypt(Customer customer, Demand demand)` : returns an encrypted copy of the customer for the given demand context.

— `Customer encrypt(Customer customer, String strCode)` : returns an encrypted copy of the customer using the given code.

— `Customer decrypt(Customer customer, Demand demand)` : returns a decrypted copy of the customer for the given demand context.

— `Customer decrypt(Customer customer, String strCode)` : returns a decrypted copy of the customer using the given code.

 `fr.paris.lutece.plugins.grubusiness.business.indexing.IIndexingService` — Generic indexing service interface. Exposes:

— `void index(T object)` : indexes a single object.

— `void indexList(List<T>listObjects)` : indexes a list of objects.

— `void deleteIndex(T object)` : removes the index entry for a given object.

— `void deleteAllIndexes()` : removes all index entries.

 **Generic status enumeration** 

The `EnumGenericStatus` enumeration defines the standard demand statuses used across the GRU platform: ONGOING (11), TOPAY (12), TOCOMPLETE (13), PAID (14), CLOSED (15), CANCELED (10), UNDEFINED (-1).The statuses CLOSED, PAID and CANCELED are marked as final statuses.Internationalized labels are defined in `grubusiness_messages.properties` (English) and `grubusiness_messages_fr.properties` (French).

 **REST response model** 

The classes in `fr.paris.lutece.plugins.grubusiness.business.web.rs` provide a standard REST response structure for consuming plugins: `SearchResult` (abstract base with status, paginator and result count), `DemandResult` (list of `DemandDisplay` ), `NotificationResult` (list of `Notification` ), `ResponseStatus` (HTTP code + typed status + optional message), and `ResponseStatusFactory` (factory methods for all standard HTTP response codes: ok, success, badRequest, unauthorized, notFound, conflict, internalServerError, etc.).

 **Listener interfaces** 

Plugins wishing to react to demand or notification lifecycle events must implement the following interfaces and register them as Spring beans:

— `IDemandListener` : `onCreateDemand(Demand)` , `onUpdateDemand(Demand)` , `onDeleteDemand(String, String)` .

— `INotificationListener` : `onCreateNotification(Notification)` , `onUpdateNotification(Notification)` , `onDeleteDemand(String, String)` .

 **Mock implementations for unit testing** 

The package `fr.paris.lutece.plugins.grubusiness.business.mock` provides in-memory implementations of all DAO and listener interfaces: `MockCustomerDAO` , `MockDemandDAO` , `MockNotificationDAO` , `MockNotificationEventDAO` , `MockDemandListener` , `MockNotificationListener` . These are intended for unit testing only and must not be used in production configurations.


[Maven documentation and reports](https://dev.lutece.paris.fr/plugins/library-grubusiness/)



 *generated by [xdoc2md](https://github.com/lutece-platform/tools-maven-xdoc2md-plugin) - do not edit directly.*