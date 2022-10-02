
      _   _ _  __ _    ____                          
     | \ | (_)/ _(_)  / ___|___  _   _ _ __ ___  ___ 
     |  \| | | |_| | | |   / _ \| | | | '__/ __|/ _ \
     | |\  | |  _| | | |__| (_) | |_| | |  \__ \  __/
     |_| \_|_|_| |_|  \____\___/ \__,_|_|  |___/\___|



A Repository to host nifi course material.

## A typical layout of this course

    ├── installation                        # guide for installating nifi standalone/cluster for both secure/insecure mode
        ├── docker                          # demonstration of docker based installation
            ├── cluster                     # 2 node cluster setup (secure/insecure)
            └── standalone                  # single node setup (secure/insecure)
            ..
        ├── vm-setup                        # demonstration of bare-metal vm based installation
            ├── cluster    
            └── standalone
    ├── monitoring                          # nifi monitoring with prometheus and grafana
    ├── presentation-slides                 # slides used during course (copyright reserved, distribution in public is restrictly prohibited)
    ├── productionizing                     # nifi in production architecture
    ├── templates                           # nifi templates which contains all nifi operations illustrated in the course
        ├── sample-input-data               # sample input data used in the templates
            ├── data.csv                    # data in csv format
            └── data.json                   # data in json format
        ├── Converting-CSV-to-JSON.xml      # template which converts csv to json
        ├── Creating-Web-Service.xml        # template which exposes web services
        ...
        ...
        └── Updating-Record-Record_Path.xml # template which updates flowfile records using record path
    ├── README.md
    └── best-practices-and-general-guidelines.md
