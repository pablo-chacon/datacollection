# datacollection

Educational project, I havent invented anything. 

Simple port scanner targeting ports: 22, 2222, 80, 8080, 8081, 20, 25, 53.
Simple Web Crawler crawls website.
Simple Web Scraper, scrapes html content.

Coming features:
New Scraper utilizing Jaunt to add scraping API:s. https://jaunt-api.com/
Read URL:s from a file.
Write scan, scrape and crawl results to as CSV file.
Run program each 24 h.

Short about the program:

Web Crawler cycles through all links at a target URL.
Web Scaraper collects title of target URL.
Porst scanner scan target IP and ports each port has a individual thread. 
Ports: 
22, 2222 SSH 
80, 8080, 8081 HTTP
20 FTP
25 SMTP
53 DNS
