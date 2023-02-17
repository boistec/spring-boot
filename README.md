<!-- GETTING STARTED -->
## Getting Started
This is the result of watching https://app.pluralsight.com/library/courses/creating-first-spring-boot-application/

Added  `docker-compose.yaml` file to speed up the learning process of Spring Boot, not recomended for `PRODUCTION ENVIRONMENT` but for testing pourposes.

### Installation
Follow the instructions to have data you need within the containers. 

1. Clone the repo
2. Install docker, then, at the root level of the proyect execute the compose command (use -d for a detached process)
   ```sh
   docker-compose up -d
   ```
3. Connect to the database in the container
   ```sh
   docker exec -it postgres_demo psql -U postgres   
   ```
4. Create the database
   ```sh
   create database conference_app;
   ```
5. Initial data. Execute the shell command on linux/iOS. For windows you can copy and paste the commands.
   ```sh
   ./create_data.sh
   ```
6. Open pgAdmin4. Take a look at the `PGADMIN_DEFAULT_EMAIL` and `PGADMIN_DEFAULT_PASSWORD` variables.
   ```sh
   http://localhost:5050/
   ```
7. Connect to the database using the postgrest container as hostname
   ```js
   Host name = 'postgres_demo'
   Username  = 'postgres'
   Password  = 'Welcome'
   ```

### Troubleshooting

1. If you already execute the `docker-compose` command, you might need to delete the volumes or a particular       volumen (change passwords or something else). `-v` WILL DELETE ALL THE VOLUMNES, start from scratch.
   ```sh
   docker-compose down -v
   ```
