// Compiled by ClojureScript 1.10.516 {:static-fns true, :optimize-constants true}
goog.provide('reveal.klipse');
goog.require('cljs.core');
goog.require('cljs.core.constants');
goog.require('hiccups.runtime');
goog.require('reveal.example_data');
reveal.klipse.code_html = (function reveal$klipse$code_html(hidden_quoted_code,quoted_code){
return ["<div"," style=\"font-size: 33px;\"",">","<pre"," hidden=\"hidden\"",">",(function (){var attrs13284 = cljs.core.str.cljs$core$IFn$_invoke$arity$1(hidden_quoted_code);
if(cljs.core.map_QMARK_(attrs13284)){
return ["<code",cljs.core.str.cljs$core$IFn$_invoke$arity$1(hiccups.runtime.render_attr_map(cljs.core.merge.cljs$core$IFn$_invoke$arity$variadic(cljs.core.prim_seq.cljs$core$IFn$_invoke$arity$2([new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$id,null,cljs.core.cst$kw$class,"klipse"], null),attrs13284], 0))))," />"].join('');
} else {
return ["<code class=\"klipse\">",cljs.core.str.cljs$core$IFn$_invoke$arity$1(hiccups.runtime.render_html(attrs13284)),"</code>"].join('');
}
})(),"</pre>","<pre","",">",(function (){var attrs13285 = cljs.core.str.cljs$core$IFn$_invoke$arity$1(quoted_code);
if(cljs.core.map_QMARK_(attrs13285)){
return ["<code",cljs.core.str.cljs$core$IFn$_invoke$arity$1(hiccups.runtime.render_attr_map(cljs.core.merge.cljs$core$IFn$_invoke$arity$variadic(cljs.core.prim_seq.cljs$core$IFn$_invoke$arity$2([new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$id,null,cljs.core.cst$kw$class,"klipse"], null),attrs13285], 0))))," />"].join('');
} else {
return ["<code class=\"klipse\">",cljs.core.str.cljs$core$IFn$_invoke$arity$1(hiccups.runtime.render_html(attrs13285)),"</code>"].join('');
}
})(),"</pre>","<link href=\"https://storage.googleapis.com/app.klipse.tech/css/codemirror.css\" rel=\"stylesheet\" type=\"text/css\" />","<script>window.klipse_settings = {selector: '.klipse',\ncodemirror_options_in: {autoCloseBrackets: true}};</script>","<script src=\"https://storage.googleapis.com/app.klipse.tech/plugin/js/klipse_plugin.js\"></script>","</div>"].join('');
});
/**
 * Code parameters must be quoted
 */
reveal.klipse.klipse_snippet = (function reveal$klipse$klipse_snippet(p__13292){
var map__13293 = p__13292;
var map__13293__$1 = (((((!((map__13293 == null))))?(((((map__13293.cljs$lang$protocol_mask$partition0$ & (64))) || ((cljs.core.PROTOCOL_SENTINEL === map__13293.cljs$core$ISeq$))))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__13293):map__13293);
var hidden_code = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__13293__$1,cljs.core.cst$kw$hidden_DASH_code);
var code = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__13293__$1,cljs.core.cst$kw$code);
var height = cljs.core.get.cljs$core$IFn$_invoke$arity$3(map__13293__$1,cljs.core.cst$kw$height,"200px");
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$iframe,new cljs.core.PersistentArrayMap(null, 4, [cljs.core.cst$kw$sandbox,"allow-scripts",cljs.core.cst$kw$height,height,cljs.core.cst$kw$width,"100%",cljs.core.cst$kw$srcdoc,reveal.klipse.code_html(hidden_code,code)], null)], null);
});
