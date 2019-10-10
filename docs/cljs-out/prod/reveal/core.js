// Compiled by ClojureScript 1.10.516 {:static-fns true, :optimize-constants true}
goog.provide('reveal.core');
goog.require('cljs.core');
goog.require('cljs.core.constants');
goog.require('clojure.string');
goog.require('goog.dom');
goog.require('hiccups.runtime');
goog.require('reveal.slides');
reveal.core.options = cljs.core.clj__GT_js(new cljs.core.PersistentArrayMap(null, 5, [cljs.core.cst$kw$controls,true,cljs.core.cst$kw$progress,true,cljs.core.cst$kw$transition,"slide",cljs.core.cst$kw$slideNumber,false,cljs.core.cst$kw$dependencies,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$src,"node_modules/reveal/plugin/notes/notes.js",cljs.core.cst$kw$async,true], null),new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$src,"node_modules/reveal/plugin/highlight/highlight.js",cljs.core.cst$kw$async,true], null)], null)], null));
/**
 * Get list of all slides and convert them to html strings.
 */
reveal.core.convert = (function reveal$core$convert(){
var slides = reveal.slides.all();
return clojure.string.join.cljs$core$IFn$_invoke$arity$1(cljs.core.map.cljs$core$IFn$_invoke$arity$2(((function (slides){
return (function (p1__11411_SHARP_){
return cljs.core.str.cljs$core$IFn$_invoke$arity$1(hiccups.runtime.render_html(p1__11411_SHARP_));
});})(slides))
,slides));
});
/**
 * Get all slides, set them as innerHTML and reinitialize Reveal.js
 */
reveal.core.main = (function reveal$core$main(){
goog.dom.getElement("slides").innerHTML = reveal.core.convert();

Reveal.initialize(reveal.core.options);

return Reveal.setState(Reveal.getState());
});
reveal.core.main();
