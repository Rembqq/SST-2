
`mvn clean package` - _creates jar file in target/sst2-0.0.1-SNAPSHOT.jar_

### Docker
**Build:**
`docker build . -t <image_name>:latest`

**Run:**
`docker run -it --rm --network=host -e PORT=<your_port>
<image_name>:latest` <br> OR
<br>
`docker run -it --rm --network=host -p <external_port>:<inner_port> <image_name>:latest`
<br></br>
**Windows enjoyers should use:**
`docker run -it --rm -p <external_port>:<inner_port> <image_name>:latest`

<br>**Additional docker commands:**
```
docker ps
docker exec -it <container_id> /bin/bash
curl <destination ip>
```