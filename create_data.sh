docker cp ./database/postgresql/tables.sql postgres_demo:/tables.sql
docker exec -it postgres_demo psql -d conference_app -f tables.sql -U postgres

docker cp ./database/postgresql/data.sql postgres_demo:/data.sql
docker exec -it postgres_demo psql -d conference_app -f data.sql -U postgres
