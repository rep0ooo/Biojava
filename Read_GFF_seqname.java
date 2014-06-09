package bio;
import java.util.Iterator;//配列・行列などに繰り返すを行えるインターフェース

import org.biojava3.genome.parsers.gff.FeatureI;
import org.biojava3.genome.parsers.gff.FeatureList;
import org.biojava3.genome.parsers.gff.GFF3Reader;


//染色体番号抽出
public class Read_GFF_seqname {

public static void main(String[] args) throws Exception {

FeatureList features =(FeatureList)
GFF3Reader.read("/Users/admin/Dropbox/workspace/bio/test.gtf");
Iterator<FeatureI> featureIterator = features.iterator();

FeatureI row = null;
String data1;
while (featureIterator.hasNext()) {
row = featureIterator.next();
data1=row.seqname();
System.out.println(data1);
}
}
}
