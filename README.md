A game implemented in ClojureScript using the Core.async library.

## A fork of dotsters

[See the blog post explaining the game](http://rigsomelight.com/2013/08/12/clojurescript-core-async-dots-game.html)

[Play the game](http://rigsomelight.com/dotsters)

## Changes

### nrepl based workflow

Use `lein cljsbuild once` to compile the current game and repl
connection javascript. Then in a nrepl session, load server.clj. That
namespace contains a function `run` which will start a jetty server
with two main endpoints. Additionally, a function `brepl` will
transform the current nrepl session into a cljs repl.

1.`http://localhost:8080` is the uri to see the game running
2.`http://localhost:8080/repl` is the uri to access a cljs repl

In the cljs repl, it is possible to load the game code and
incrementally change it for development.


## License

Copyright © 2013

Distributed under the Eclipse Public License, the same as Clojure.
