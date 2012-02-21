if [ -f lib/libjcurses.dll ]; then
  rm lib/libjcurses.dll
fi

java -jar cvrl.jar jc
