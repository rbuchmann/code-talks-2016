# choeropsis

A little microservice, no pun intended, written during the live coding
at the code talks 2016. It needs gitwellsoon, which needs code-maat,
both of which aren't available via clojars (yet, looking at you,
gentle viewer, nudge, wink). You will have to clone and lein install
them both first, starting with code-maat.

## Known issues

Gitwellsoon is a very basic implementation of fetching commits from
github, it doesn't download all commits (paging isn't implemented
correctly), and errors could be handled better.

## Usage

### Run the application locally


```
# Set up your git account
cp lein-env-example .lein-env
$EDITOR .lein-env
# start the rethinkdb server
rethinkdb
# start the app
lein ring server
```

## License

Copyright © 2016 Rasmus Buchmann

Distributed under the
[GNU General Public License v3.0](http://www.gnu.org/licenses/gpl.html),
same as code-maat.
