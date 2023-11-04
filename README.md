# Network Communication Project

This project simulates the communication between ten nodes using a simple Java application encapsulated in Docker containers.

## Prerequisites

- Docker
- Java 11
- Git

## Installation

1. Clone the repository:
```bash
git clone https://github.com/wanshiqi84/Network_final_project.git
Navigate to the project directory:
bash
Copy code
cd Network_final_project
Build the Docker image:
bash
Copy code
./run_nodes.sh
Usage
To start the simulation, simply run the shell script:

bash
Copy code
./run_nodes.sh
This script will set up the Docker network and start ten containers, each representing a node in the network.

To stop all nodes, run:

bash
Copy code
./stop_nodes.sh
