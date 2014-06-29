package bio;
import java.util.Iterator;//配列・行列などに繰り返すを行えるインターフェース

import org.biojava3.genome.parsers.gff.FeatureI;
import org.biojava3.genome.parsers.gff.FeatureList;
import org.biojava3.genome.parsers.gff.GFF3Reader;


//Attribuite("この内容を含むかどうかyesorno")
public class Read_GFF_hasAttribute {

public static void main(String[] args) throws Exception {

FeatureList features =(FeatureList)
GFF3Reader.read("読み込みたいgtf名/path.gtf");
Iterator<FeatureI> featureIterator = features.iterator();

FeatureI row = null;
Boolean data1;
while (featureIterator.hasNext()) {
row = featureIterator.next();
data1=row.hasAttribute("transcript_id");
System.out.println(data1);
}
}
}
