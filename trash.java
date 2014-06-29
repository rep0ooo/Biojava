package bio;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.biojava3.genome.parsers.gff.FeatureI;
import org.biojava3.genome.parsers.gff.FeatureList;
import org.biojava3.genome.parsers.gff.GeneMarkGTFReader;
import org.biojava3.genome.parsers.gff.Location;

public class dfaw {

	public static void main(String[] args) throws Exception {
		System.setProperty("http.proxyHost", "cache.tmd.ac.jp");
		System.setProperty("http.proxyPort", "8080");

		// mm10ゲノム取得・ListからArrayにする(2次元配列にする)(超重要)
		// List<GeneChromosomePosition>
		// test4=GeneChromosomePositionParser.getChromosomeMappings();
		// Iterator<GeneChromosomePosition> test5 =test4.iterator();
		FeatureList features = (FeatureList) GeneMarkGTFReader
				.read("/Users/admin/Dropbox/workspace/bio/testWT.gtf");
		Iterator<FeatureI> featureIterator = features.iterator();
		FeatureI rowWT = null;
		FeatureList features1 = (FeatureList) GeneMarkGTFReader
				.read("/Users/admin/Dropbox/workspace/bio/testKI.gtf");
		Iterator<FeatureI> featureIterator2 = features1.iterator();
		FeatureI rowKI = null;
		FeatureI featureList = null;
		Map<String, String> WT = new HashMap<>();
		FeatureList listC1 = new FeatureList();
		for (int i = 0; i < features.size(); i++) {
			featureList = features.get(i);
			for (int j = 0; j < features1.size(); j++) {
				FeatureI aaa = features1.get(j);
				if (featureList.getAttribute("transcript_id").contains("N")) {
					if (featureList.getAttribute("exon_number") != null) {
						if (aaa.getAttribute("exon_number") != null) {
							WT.put(featureList.getAttribute("transcript_id"),
									featureList.getAttribute("exon_number"));
							break;
						}
					}
				}
			}
			// WTでtranscript_id NM_,NR_から始まるIDのexonとtranscrptIDを抽出ヒモ付
		}
		System.out.println(WT);
		System.out.println(listC1);
		FeatureI featureList2;
		Map<String, String> KI = new HashMap<>();
		for (int k = 0; k < features1.size(); k++) {
			featureList2 = features1.get(k);
			for (int l = 0; l < features.size(); l++) {
				FeatureI aaaaa = features.get(l);
				if (featureList2.getAttribute("transcript_id").contains("N")) {
					if (featureList2.getAttribute("exon_number") != null) {
						if (aaaaa.getAttribute("exon_number") != null) {

							KI.put(featureList2.getAttribute("transcript_id"),
									featureList2.getAttribute("exon_number"));
							break;
						}
					}
				}
			}
		}

		System.out.println(KI);
		for (String key : WT.keySet()) {
			String data = WT.get(key);
			String KIdata = KI.get(key);

			if (data.equals(KIdata)) {
			} else {
				System.out.println("SplicingVariant");// detect完了
			}

		}

		// 以下一度考えた残骸
		// {

		// }
		// System.out.println(listC1);
		while (featureIterator.hasNext()) {
			while (featureIterator2.hasNext()) {
				// GeneChromosomePosition test6= test5.next();
				rowWT = featureIterator.next();
				String WTRNAID = rowWT.getAttribute("transcript_id");
				Location WTloc = rowWT.location();
				int WTlength = WTloc.length();
				String WTtype = rowWT.type();
				String WTexonNumber = rowWT.getAttribute("exon_number");

				rowKI = featureIterator2.next();
				String KIRNAID = rowKI.getAttribute("transcript_id");
				Location KIloc = rowKI.location();
				int KIlength = KIloc.length();
				String KItype = rowKI.type();
				String KIexonNumber = rowKI.getAttribute("exon_number");

				if (KItype.contains("exon")) {

					if (KIRNAID.contains("N")) {

						if (KIexonNumber.equals(WTexonNumber)) {

						}
					}
				}
				if (WTtype.contains("exon")) {
					if (WTRNAID.contains("N")) {

					}
				}

			}

		}
	}
}

// (){
// if(){
//
// }
// }

// if (){
//
// }

// if(exonsa!=0)
// System.out.println(exonsa);
// System.out.println("SplicingVariant:exon" + WTRNAID+ " "+ WTexonNumber+
// " "+KIexonNumber);

// }

// else if (WTRNAID.contains("CUFF_")&&KIRNAID.contains("CUFF_")&&
// WTexonNumber==KIexonNumber)
// {System.out.println("NotSpricingVariant");
// }

// else if (WTRNAID.contains("CUFF_")&&KIRNAID.contains("CUFF_")&&
// WTexonNumber!=KIexonNumber){
// System.out.println("SplicingVariant");

// catch (Exception e) {
// TODO: handle exception

// }
// }
// }}

