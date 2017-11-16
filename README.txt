JAVA TECHNOLOGIES USED:
Java - JDK 8
Apache HTTP client
JSON Simple API

PRE-REQUISITES. 
This project assumes you already have Java jdk1.8.0_101 or equivalent) and Apache apache-maven-3.3.9 (or equivalent) installed in your machine

1. If you have not already done so, go to http://intrinio.com and sign up as a developer using your email and a password. Intrinio is awesome, you should join!
2. Check out the code from github
3. Modify the com.intrinio.Main.java file by replacing YOUR_API_USERNAME and YOUR_API_PASSWORD with your own intrinio username and password. Once signed up into intrinio scroll way down your home page and find the "ACCESS KEY" section and copy these from there.
4. From the project root directory run the following commands.
a. mvn clean install
b. run (relies on httpclient-4.5.3.jar, httpcore-4.4.8.jar, commons-logging-1.2.jar, commons-codec-1.9.jar, json-simple-1.1.1.jar) to run. Make sure you have these on the lib directory or modify the <ROOT>/run.bat file. If you are not using windows, write a script equivalent to the run batch file.

I used the a blog that contains how to for  to build the java app. Get more information from  http://blog.intrinio.com/stock-api-developers/

Sample output using AAPL as the stock.

https://github.com/pmkent/intrinio-java-sample.git

.\intrinio-java-sample_GitHub>java -cp target/java-sample-1.0.jar;lib/httpclient-4.5.3.jar;lib/httpcore-4.4.8.jar;lib
/commons-logging-1.2.jar;lib/commons-codec-1.9.jar;lib/json-simple-1.1.1.jar com.intrinio.Main
TODAY is 2017-11-15

statusCode is 200

{"data":[{"identifier":"AAPL","item":"open_price","value":169.97},{"identifier":"AAPL","item":"last_price","value":169.085},{"identifier":"AAPL","item
":"close_price","value":169.08},{"identifier":"AAPL","item":"volume","value":28702351.0},{"identifier":"AAPL","item":"pricetoearnings","value":18.3648
},{"identifier":"AAPL","item":"name","value":"Apple Inc"},{"identifier":"AAPL","item":"ticker","value":"AAPL"},{"identifier":"AAPL","item":"security_n
ame","value":"APPLE INC"},{"identifier":"AAPL","item":"market_sector","value":"Equity"},{"identifier":"AAPL","item":"security_type","value":"Common St
ock"},{"identifier":"AAPL","item":"stock_exchange","value":"NasdaqGS"},{"identifier":"AAPL","item":"short_description","value":"Apple, Inc. engages in
 the design, manufacture, and marketing of mobile communication, media devices, personal computers, and portable digital music players. It operates th
rough the following geographical segments: Americas, Europe, Greater China, Japan, and Rest of Asia Pacific. The Americas segment includes both North
and South America. The Europe segment consists of European countries, as well as India, the Middle East, and Africa. The Greater China segment compris
es of China, Hong Kong, and Taiwan. The Rest of Asia Pacific segment includes Australia and Asian countries not included in the reportable operating s
egments of the company. The company was founded by Steven Paul Jobs, Ronald Gerald Wayne, and Stephen G. Wozniak on April 1, 1976 and is headquartered
 in Cupertino, CA."},{"identifier":"AAPL","item":"long_description","value":"Apple Inc. designs, manufactures, and markets mobile communication and me
dia devices, personal computers, and portable digital music players to consumers, small and mid-sized businesses, and education, enterprise, and gover
nment customers worldwide. The company also sells related software, services, accessories, networking solutions, and third-party digital content and a
pplications. It offers iPhone, a line of smartphones; iPad, a line of multi-purpose tablets; and Mac, a line of desktop and portable personal computer
s. The company also provides iLife, a consumer-oriented digital lifestyle software application suite; iWork, an integrated productivity suite that hel
ps users create, present, and publish documents, presentations, and spreadsheets; and other application software, such as Final Cut Pro, Logic Pro X,
and FileMaker Pro. In addition, it offers Apple TV that connects to consumers' TV and enables them to access digital content directly for streaming hi
gh definition video, playing music and games, and viewing photos; Apple Watch, a personal electronic device; and iPod, a line of portable digital musi
c and media players. Further, the company sells Apple-branded and third-party Mac-compatible, and iOS-compatible accessories, such as headphones, disp
lays, storage devices, Beats products, and other connectivity and computing products and supplies. Additionally, it offers iCloud, a cloud service; Ap
pleCare that offers support options for its customers; and Apple Pay, a mobile payment service. The company sells and delivers digital content and app
lications through the iTunes Store, App Store, Mac App Store, TV App Store, iBooks Store, and Apple Music. It also sells its products through its reta
il and online stores, and direct sales force, as well as through third-party cellular network carriers, wholesalers, retailers, and value-added resell
ers. Apple Inc. was founded in 1977 and is headquartered in Cupertino, California."},{"identifier":"AAPL","item":"ceo","value":"Tim Cook"},{"identifie
r":"AAPL","item":"company_url","value":"www.apple.com"},{"identifier":"AAPL","item":"business_address","value":"ONE INFINITE LOOP, CUPERTINO, CA 95014
"},{"identifier":"AAPL","item":"mailing_address","value":"ONE INFINITE LOOP, CUPERTINO, CA 95014"},{"identifier":"AAPL","item":"business_phone_no","va
lue":"(408) 996-1010"},{"identifier":"AAPL","item":"employees","value":116000},{"identifier":"AAPL","item":"sector","value":"Consumer Goods"},{"identi
fier":"AAPL","item":"industry_category","value":"Consumer Durables"},{"identifier":"AAPL","item":"industry_group","value":"Electronic Equipment"},{"id
entifier":"AAPL","item":"price_date","value":"2017-11-15"},{"identifier":"AAPL","item":"totalrevenue","value":0.229234E12},{"identifier":"AAPL","item"
:"percent_change","value":-0.0132},{"identifier":"AAPL","item":"marketcap","value":887956083360.0},{"identifier":"AAPL","item":"dividend","value":0.63
},{"identifier":"AAPL","item":"basiceps","value":0.927E1},{"identifier":"AAPL","item":"roe","value":0.368675E0}],"result_count":29,"api_call_credits":
29}



CommonStock -
Symbol : 'AAPL',
Quote : 169.085,
P/E : 18.3648',
Volume : 0',
Market Sector : 'Equity'',
Type : 'Common Stock'',
Exchange : 'NasdaqGS'',
Business : 'Apple Inc. designs, manufactures, and markets mobile communication and media devices, personal computers, and portable digital music playe
rs to consumers, small and mid-sized businesses, and education, enterprise, and government customers worldwide. The company also sells related softwar
e, services, accessories, networking solutions, and third-party digital content and applications. It offers iPhone, a line of smartphones; iPad, a lin
e of multi-purpose tablets; and Mac, a line of desktop and portable personal computers. The company also provides iLife, a consumer-oriented digital l
ifestyle software application suite; iWork, an integrated productivity suite that helps users create, present, and publish documents, presentations, a
nd spreadsheets; and other application software, such as Final Cut Pro, Logic Pro X, and FileMaker Pro. In addition, it offers Apple TV that connects
to consumers' TV and enables them to access digital content directly for streaming high definition video, playing music and games, and viewing photos;
 Apple Watch, a personal electronic device; and iPod, a line of portable digital music and media players. Further, the company sells Apple-branded and
 third-party Mac-compatible, and iOS-compatible accessories, such as headphones, displays, storage devices, Beats products, and other connectivity and
 computing products and supplies. Additionally, it offers iCloud, a cloud service; AppleCare that offers support options for its customers; and Apple
Pay, a mobile payment service. The company sells and delivers digital content and applications through the iTunes Store, App Store, Mac App Store, TV
App Store, iBooks Store, and Apple Music. It also sells its products through its retail and online stores, and direct sales force, as well as through
third-party cellular network carriers, wholesalers, retailers, and value-added resellers. Apple Inc. was founded in 1977 and is headquartered in Cuper
tino, California.'',
Ceo : 'Tim Cook'',
Url : 'www.apple.com'',
Address : 'ONE INFINITE LOOP, CUPERTINO, CA 95014'',
Phone : (408) 996-1010',
Employees # : 116000',
Sector : 'Consumer Goods'',
Industry Category : 'Consumer Durables'',
Industry Group : 'Electronic Equipment'',
Quote Date : Wed Nov 15 00:00:00 EST 2017',
Change : -0.0132,
Market Cap : 8.8795608336E11,
Dividend : 0.63,
EPS : 9.27,