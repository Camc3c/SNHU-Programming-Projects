# Draw It or Lose It: Software Recommendations

## Operating Platform
- **Recommendation:** Use the Linux operating system.
- **Key Benefits:**
  - Open-source, cost-effective, and widely used for server environments.
  - High scalability and performance to accommodate growth.
  - Extensive compatibility with modern web frameworks.
  - Community-driven support for continuous improvement.

## Operating System Architectures
- **Architecture:** Monolithic kernel architecture.
- **Features:**
  - Integration of essential services like file management and memory handling directly into the kernel for high performance.
  - Modular design enabling flexibility by loading/unloading kernel modules as needed.

## Storage Management
- **Recommended System:** Ext4 (Fourth Extended Filesystem).
- **Key Features:**
  - Journaling for enhanced data integrity and fault tolerance.
  - Cloud-based storage options, such as AWS S3, for redundancy and disaster recovery.

## Memory Management
- **Techniques Used by Linux:**
  - Advanced virtual memory and demand paging for dynamic allocation.
  - Memory prioritization for real-time game states and secondary storage for less-used data.
  - Memory compression and swap space to handle high user loads efficiently.

## Distributed Systems and Networks
- **Architecture:** Client-server model.
- **Communication Protocols:** RESTful APIs for low-latency, real-time interaction.
- **Reliability Measures:**
  - Load balancers to distribute traffic evenly.
  - Redundant, geographically distributed data centers for uptime and connectivity.

## Security
- **Platform Security Features:**
  - SELinux for access control and iptables for network security.
  - TLS encryption for safeguarding data in transit.
  - OAuth for secure user authentication and multi-factor authentication to enhance protection.
- **Additional Measures:** Regular updates, security audits, and monitoring tools (e.g., fail2ban) to mitigate risks.

## Conclusion
The outlined recommendations provide a comprehensive, secure, and scalable solution for the development and deployment of **Draw It or Lose It** as a multi-platform web-based game. By leveraging Linux’s capabilities and modern software design principles, The Gaming Room can meet its goals for user satisfaction, performance, and security.

## Q&A Section

### 1. Briefly summarize The Gaming Room client and their software requirements. Who was the client? What type of software did they want you to design?
The Gaming Room is a client aiming to expand their Android-only game, **Draw It or Lose It**, into a web-based application for multiple platforms. The software required a scalable, secure, and cross-platform solution with robust features like unique identifiers for games, teams, and players, as well as efficient memory control.

### 2. What did you do particularly well in developing this documentation?
The documentation effectively connects technical decisions to client requirements, offering detailed explanations and justifications. The focus on scalability, user experience, and security ensures a cohesive, client-focused solution.

### 3. What about the process of working through a design document did you find helpful when developing the code?
The design document provided clarity on system requirements and constraints, allowing for structured problem-solving. It helped identify key areas like security, storage, and distributed systems early, ensuring the code aligned with the client’s goals.

### 4. If you could choose one part of your work on these documents to revise, what would you pick? How would you improve it?
I would expand the recommendations for distributed systems by including specific examples of cloud services, like Kubernetes for container orchestration. This would enhance the practicality and depth of the solutions.

### 5. How did you interpret the user’s needs and implement them into your software design? Why is it so important to consider the user’s needs when designing?
User needs were interpreted through the client’s focus on scalability, security, and cross-platform compatibility. These were addressed with a Linux-based system, robust memory and storage strategies, and secure communication protocols. Addressing user needs ensures the product delivers value and functionality, fostering long-term success.

### 6. How did you approach designing software? What techniques or strategies would you use in the future to analyze and design a similar software application?
The approach included thorough analysis of requirements, UML modeling, and alignment with software design principles. In the future, I would incorporate agile development practices, iterative feedback loops, and advanced testing methodologies to refine the design process further.

