
中間ファイルを使うバッチアプリケーションのサンプルです。

mvn archetype:generate -DarchetypeCatalog=http://asakusafw.s3.amazonaws.com/maven/archetype-catalog-0.4.xml
から作成しています。



ビルド完了後のデプロイ＆実行手順

	cp target/*batchapps*.jar $ASAKUSA_HOME/batchapps
	
	cd $ASAKUSA_HOME/batchapps
	
	jar xf *batchapps*.jar
	
	mkdir $HOME/tmp
	
	mkdir $HOME/tmp/directio

	mkdir $HOME/tmp/directio/ironpeace

	mkdir $HOME/tmp/directio/ironpeace/input/
	
	cd $ASAKUSA_HOME
	
	cd ../workspace/middledatasample/
	
	cp data/originaldata.csv $HOME/tmp/directio/ironpeace/input/
	
	ls $HOME/tmp/directio/ironpeace/input/

	$ASAKUSA_HOME/yaess/bin/yaess-batch.sh mdsBatch
	
	


