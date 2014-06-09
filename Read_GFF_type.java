package bio;
import java.util.Iterator;//配列・行列などに繰り返すを行えるインターフェース

import org.biojava3.genome.parsers.gff.FeatureI;
import org.biojava3.genome.parsers.gff.FeatureList;
import org.biojava3.genome.parsers.gff.GFF3Reader;


//exon or transcript
public class Read_GFF_type{

public static void main(String[] args) throws Exception {

FeatureList features =(FeatureList)
GFF3Reader.read("/Users/admin/Dropbox/workspace/bio/test.gtf");
Iterator<FeatureI> featureIterator = features.iterator();

FeatureI row = null;
String data2;
while (featureIterator.hasNext()) {
row = featureIterator.next();
data2=row.type();
System.out.println(data2);
}
}
}
