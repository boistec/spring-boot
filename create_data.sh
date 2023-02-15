docker cp ./database/postgresql/create_tables.sql postgres_demo:/create_tables.sql
docker exec -it postgres_demo psql -d conference_app -f create_tables.sql -U postgres

docker cp ./database/postgresql/insert_data.sql postgres_demo:/insert_data.sql
docker exec -it postgres_demo psql -d conference_app -f insert_data.sql -U postgres
