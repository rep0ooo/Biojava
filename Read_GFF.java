package bio;
import java.util.Iterator;//配列・行列などに繰り返すを行えるインターフェース

import org.biojava3.genome.parsers.gff.FeatureI;
import org.biojava3.genome.parsers.gff.FeatureList;
import org.biojava3.genome.parsers.gff.GFF3Reader;



public class Read_GFF {

public static void main(String[] args) throws Exception {

FeatureList features =(FeatureList)
GFF3Reader.read("読み込みたいgtf名/path.gtf");
Iterator<FeatureI> featureIterator = features.iterator();

FeatureI row = null;

while (featureIterator.hasNext()) {
row = featureIterator.next();
System.out.println(row);
}
}
}
