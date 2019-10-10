//Modified from https://raw.githubusercontent.com/viebel/klipse/master/docs/examples/klipse_reveal.js
{

let jsSrc = (lang) => {
    if (lang === 'clojure') {
        return 'https://storage.googleapis.com/app.klipse.tech/plugin/js/klipse_plugin.js'
    }
    return 'https://storage.googleapis.com/app.klipse.tech/plugin/js/klipse_plugin.js'
}


let createIFrame = (lang,src) => {
    return `<iframe sandbox="allow-scripts" height="100px" width="100%" srcdoc='
    <pre><code class=&quot;klipse&quot;>${src}</code></pre>

      <link rel=&quot;stylesheet&quot; type=&quot;text/css&quot; href=&quot;https://storage.googleapis.com/app.klipse.tech/css/codemirror.css&quot;>

      <script>
        window.klipse_settings = {
          selector: &quot;.klipse&quot;
        };
      </script>
      <script src=&quot;${jsSrc(lang)}&quot;></script>
    '>
    </iframe>`
};

    let klipsify = (elem) => {
        elem.innerHTML = createIFrame(elem.dataset.language, elem.innerHTML);
        return elem;
    }

    document.querySelectorAll('klipse-snippet').forEach(x => klipsify(x))
}
