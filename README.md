<!-- GETTING STARTED -->
## Getting Started

Environment to speed up the learning process of Spring Boot. The `docker-compose.yaml` file is not recomended for `PRODUCTION ENVIRONMENT` but for testing pourposes.

### Installation


1. Clone the repo
2. Install docker, then, at the root level of the proyect execute the compose command (use -d for a detached process)
   ```sh
   docker-compose up -d
   ```
3. Connect to the database in the container
   ```sh
   docker exec -it postgres-demo psql -U postgres   
   ```
4. Create the database
   ```sh
   create database conference_app;
   ```
5. Initial data. Execute the shell command on linux/iOS. For windows you can copy and paste the commands.
   ```sh
   .\create_data.sh
   ```
6. Open pgAdmin4. Take a look at the `PGADMIN_DEFAULT_EMAIL` and `PGADMIN_DEFAULT_PASSWORD` variables.
   ```sh
   http://localhost:5050/
   ```
7. Connect to the database using the postgrest container as hostname
   ```js
   hostname = 'postgres_demo'
   user     = 'postgres'
   password = 'Welcome'
   ```
