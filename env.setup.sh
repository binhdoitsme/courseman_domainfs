cd ./backend && docker build -t courseman_backend .
cd ..
cd ./frontend && docker build -t courseman_frontend .
cd ..
docker compose up -d