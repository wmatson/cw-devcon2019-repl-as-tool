# Coding Convenient Clojure Contraptions
#### Wesley Matson
##### Clearwater Developer Conference 2019

Despite breaking up our shared databases, we still have production issues that pertain to data and its relationships. Sql Server Management Studio can no longer serve as the one-stop investigation tool, but the Clojure REPL can.

I'll give a brief overview on the libraries I use to fight fires in production and explore the structure of good "scratchpad" projects. Much as you can save useful SQL scripts, you save Clojure ones. With a smidgen of forethought, the UI-less tools you've built for yourself can be partially reused in creating more standardized and sensible investigative tooling for operations.

Compiled slides are accessible [here](https://wmatson.github.io/cw-devcon2019-repl-as-tool/)

----
To Run in Dev Mode:
`clj -m figwheel.main -b dev -r`

----
Created with [reveal-cljs](https://github.com/n2o/reveal-cljs) and [klipse](https://github.com/viebel/klipse)
