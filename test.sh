#!/bin/bash

JASMINE_LINK="http://cloud.github.com/downloads/pivotal/jasmine/jasmine-standalone-1.3.1.zip"

function help () {
	echo Test - Just a test.
	echo Author: Shuai
}

function init_func () {
	echo "Downloading Jasmine ..."
	curl -sO $JASMINE_LINK
	unzip -q `basename $JASMINE_LINK`
	rm `basename $JASMINE_LINK` src/*.js spec/*.js
	if which xattr > /dev/null && [ "`xattr SpecRunner.html`" = "com.apple.quarantine" ]
	then
    		xattr -d com.apple.quarantine SpecRunner.html
	fi
	sed -i "" '12,18d' SpecRunner.html
	echo "Jasmine initialized!"
}

function create_func () {
	echo "function $2 () {\n\n}" > ./src/$2.js
    echo "var $2 = (function () {\n\tvar $2Prototype = {\n\n\t};\n\n\treturn {\n\t\tcreate : function (attrs) {\n\t\t\tvar o = Object.create($2Prototype);\n\t\t\textend(o, attrs);\n\t\t\treturn o;\n\t\t}\n \t};\n}());" > src/$2.js
    echo "describe('$2', function () {\nit('runs');\n});" > ./spec/$2Spec.js
    sed -i "" '11a\\
      	<script src='src/$2.js'></script>\\
      	<script src='spec/$2Spec.js'></script>
      	' SpecRunner.html
    echo "Created:"
    echo "\t- src/$2.js"
    echo "\t- spec/$2Spec.js"
    echo "Edited:"
    echo "\t- SpecRunner.html"
}

case "$1" in
	"init")
		init_func
	;;
	"create")
		if [ $2 ]
		then
    			create_func
		else
    			echo "please include a name for the file"
		fi
	;;
	run)
		echo run
	;;
	*)
		help
esac
