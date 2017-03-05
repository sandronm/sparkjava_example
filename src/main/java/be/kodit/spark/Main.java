package be.kodit.spark;

import spark.Service;

import java.nio.file.Paths;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

//        # Step 3 - No problem with the old version of Spark 2.5.1 (see pom.xml)
//        1. Run Main.class
//        2. Visit [http://localhost:8080](http://localhost:8080) => "Hello from server1"
//        3. Visit [http://localhost:8080/image.jpg](http://localhost:8080/image.jpg) => 200 **:)**
//        4. Visit [http://localhost:8181](http://localhost:8181) => "Hello from server2"
//        5. Visit [http://localhost:8181/image.jpg](http://localhost:8181/image.jpg) => 200 **:)**

        Service server1 = Service.ignite().port(8080);
        Service server2 = Service.ignite().port(8181);

        server1.externalStaticFileLocation(Paths.get("folder1").toAbsolutePath().toString());
        server2.externalStaticFileLocation(Paths.get("folder2").toAbsolutePath().toString());

        server1.get("/", (req, resp) -> "Hello from server1");
        server2.get("/", (req, resp) -> "Hello from server2");
    }
}
