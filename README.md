# Manage Inventory

A simple web service created using Spring Boot that performs CRUD operations on an Inventory.
Users of this web service can add/read/remove/update inventory items. All the data is stored in a Mongo Atlas cluster.

## application.properties

Navigate to `src/main/resources` and create a file called `application.properties`.

Content inside `application.properties`:
- The MongoDB connection string. e.g. ```mongodb+srv://<username>:<password>@cluster.jefpd.mongodb.net/inventory?retryWrites=true&w=majority```
