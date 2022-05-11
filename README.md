# Reactive programming with Project Reactor and R2DBC

[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=plastic)](https://opensource.org/licenses/MIT)

Learn about Reactive Programming in Java (watch the [webinar](https://go.mariadb.com/22Q2-WBN-GLBL-OSSG-DEV-Reactive-Programming-2022-02-24_Registration-LP.html)):

 - Start with [reactive-programming](/reactive-programming) and see how **one thread** can successfully **serve 10 
   users**.
 - Take a look at [blocking-service](/blocking-service) to see a typical REST web service with **JDBC** connections.
 - See how to use the `Flux` class and [R2DBC](https://r2dbc.io/) to build a **fully reactive** service.
 - **Compare throughput** using [Artillery](https://www.artillery.io/). See how many HTTP 200 OK responses you get on 
   each service (test scripts included on each service project).
 
# Setting up the MariaDB database

To run the experiments in this repository, you'll need a MariaDB database running on your machine with the following database and table:

```sql
CREATE DATABASE reactive;
USE reactive;

CREATE TABLE `word` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=Aria;
```

> Note: Aria is a storage engine for read-heavy workoads, but it has some limitations. See [this blog post](https://mariadb.com/resources/blog/storage-engine-choice-aria/).

Insert or import test data into this table. For example, download [this CSV file](https://www.kaggle.com/datasets/ruchi798/part-of-speech-tagging) and import it as follows:

```sql
LOAD DATA LOCAL INFILE '/path/to/words_pos.csv'
    IGNORE INTO TABLE word
    FIELDS
    TERMINATED BY ','
    LINES TERMINATED BY '\n'
    IGNORE 0 LINES
    (@dummy, text) SET text = UPPER(text);
```

## Support and Contribution

Please feel free to submit PR's, issues or requests to this project
directly.

If you have any other questions, comments, or looking for more information
on MariaDB please check out:

* [MariaDB Developer Hub](https://mariadb.com/developers)
* [MariaDB Community Slack](https://r.mariadb.com/join-community-slack)

Or reach out to us directly via:

* [developers@mariadb.com](mailto:developers@mariadb.com)
* [MariaDB Twitter](https://twitter.com/mariadb)
