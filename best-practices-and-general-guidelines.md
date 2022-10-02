# Best Practices and General Guidelines
Best practices are for Users/Developers working on ThreadConnect Projects/Integrations.

### Best Practices
1. Maximize the use of ExtractText Processor
    - ExtractText Processor extracts the content of flowfile and keeps in attribute so that other processors can make use of it. This      provides far better performance than continually processing the entire content of the flowfile as the attributes are kept in memory and updating the FlowFile repository is much faster than  updating the Content repository. 
     ```Note: Only recommended when amount of data stored in flowfile is small```
2. Always run Processors on all nodes instead of primary nodes
    - TC is built for cluster nodes paradigm and making use of all active nodes for processing is  must and best. Running on primary node should be done only if there is a probability of duplicates and it must be used in combination with RPG which helps in load balancing your data residing on primary node to all nodes.
     ```Note: The latest upgrade in TC has this feature made simple (1.8)```
3. Minimize creating multiple HandleHTTPRequest Processors
    - In background, when HandleHTTPRequest Processor is started, it creates an embedded Jetty Server which can listen for request from clients. Creating multiple such processors will end up running multiple servers which can harm memory and also impacts internal thread pool maintained by system.
     ```Note: Use single HandleHTTPRequest Processor for multiple endpoints.```
4. Make use of Funnel component when flowfiles are routed to one or more destinations
    - There are two benefits.
        - Makes the canvas much readable
        - Simplifies events executed by Provenance tasks (clone events).
     
     ```Note: It should be used only when there are more than one downstream system.```
5. Avoid using shell scripts for any written logic
    - TC has a specialized processor called ExecuteScript which supports different languages such as groovy, python that can make the logic much simpler and can avoid dependency on Ops team. If logic include system commands then one could easily make of use ExecuteStreamCommand processor. 
     ```Note: There are similar processors in the list, please look at the documentation to understand them```
6. There are similar processors in the list, please look at the documentation to understand them
    -  Expression language helps in manipulating flowfile attributes in memory and provides ability to compare flowfiles and  manipulate them. More about expression language -> https://nifi.apache.org/docs/nifi-docs/html/expression-language-guide.html
7. Enrich the use of Template component
    - Templates are designed to be reusable flows which can imported and shared across environments. Ensure to checkpoint your flow changes by creating templates.
8. Don't overload concurrent tasks from processor settings as it depends on core of the hardware where TC is running. Make use of at most 3 concurrent tasks for a processor. Overloading concurrent tasks can decrease system performance.
9. Adopt JoltTransform processor for any JSON manipulations instead of using combination of ExtractText, ReplactText etc
10. Make use of FileUpload feature for placing text-based files such XML,JSON, XSLT, TXT etc remotely which secures your confidential data from others instead of using GenerateFlowFile processor to generate your initially payload.

### General Guidelines

1. Don't run your Integration flows at root level (main canvas) instead make use of Process Group per Business, Project
Example:- Name your process group as Avaition-Group, Power-Group, Renewables-Group etc on root canvas.
2. If your integration is big, decompose them into smaller sub-flows and analyze the pattern where it can be reused to maximum extent ( make your integrations cohesive and loosely coupled ).
3. Make use of Label component for commenting and explaining your dataflows/integrations making your flows much human readable. Also employ standard naming convention to be consistent across flows.
4. Organize your projects/businesses into three Process Groups such as Ingestion, test and Monitoring. More information about this will be shared soon.
5. Be consistent with Integrations across environments and promote the deployment ( dev > qa > stage > prod)
6. Please don't leave your Dataflows/Integrations running on environments where development or testing is being done. Ensure to stop them as soon as testing is done because they might end up throwing errors if your flow depends upon external systems (causing connectivity issues) and can potentially bring down the system.
7. Use global DistributedMapCache (DMC) for storing your keys and ensure to name your keys prefixed with business/project names just to differentiate from others. Don't create DMC for each project/dataflow/Integration.