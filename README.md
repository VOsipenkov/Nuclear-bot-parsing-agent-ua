# Nuclear-bot-parsing-agent-ua

This agent parse radiation site-1

# Build version: 1.3.0

docker login
./gradlew build

# Build k8s

docker build -f Dockerfile-k8s -t vladi15151/nuclear-bot-parsing-agent-ua:1.4.1 .

# Build render

docker build -f Dockerfile-render -t vladi15151/nuclear-bot-parsing-agent-ua:1.4.1 .
docker push vladi15151/nuclear-bot-parsing-agent-ua:1.4.1