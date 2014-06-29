package bio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.biojava3.genome.parsers.gff.FeatureI;
import org.biojava3.genome.parsers.gff.FeatureList;
import org.biojava3.genome.parsers.gff.GeneMarkGTFReader;

public class SpllicingVariant {

	public static void main(String[] args) throws Exception {


			FeatureList features = (FeatureList) GeneMarkGTFReader
					.read("/Users/admin/Dropbox/workspace/bio/testWT.gtf");
			Iterator<FeatureI> featureIterator = features.iterator();
			FeatureI rowWT = null;

			// System.out.println(features.attributeValues("\"gene_id"));
			HashMap<String, HashSet<String>> WT = new HashMap<>();
			while (featureIterator.hasNext()) {
				rowWT = featureIterator.next();
				String gene_id = rowWT.getAttribute("\"gene_id");
				String transcript_id = rowWT.getAttribute("transcript_id");
				if (WT.containsKey(gene_id) != true) {
					WT.put(gene_id, new HashSet<String>());
				}
			WT.get(gene_id).add(transcript_id);
			}
			System.out.println(WT);

			FeatureList features1 = (FeatureList) GeneMarkGTFReader
					.read("/Users/admin/Dropbox/workspace/bio/testKI.gtf");
			Iterator<FeatureI> featureIterator2 = features1.iterator();
			FeatureI rowKI = null;
			HashMap<String, HashSet<String>> KI = new HashMap<>();
			while (featureIterator2.hasNext()) {
				rowKI = featureIterator2.next();
				String gene_id = rowKI.getAttribute("\"gene_id");
				String transcript_id = rowKI.getAttribute("transcript_id");
				if (KI.containsKey(gene_id) != true) {
					KI.put(gene_id, new HashSet<String>());

				}
				KI.get(gene_id).add(transcript_id);
			}
			System.out.println(KI);
	System.out.println(WT);

			// HashSet<String> data = null;
			// for (String key : WT.keySet()) {
			// data = WT.get(key);
		}
	}

	// やりたいこと

	// 近いLocationで
	// transcriptの数が一緒かどうか比較
	// 長さがちがうかどうか
	// exonの数が違うかどうか
	// Locationなどで
	// データベースで書いたほうが早いか
	// System.out.println(data3); }

	// MAPはkey重複を許さない.上書きされる
	// HashMap<Collection<String>, Collection<String>> WT = new HashMap<>();
	// WT.put(features.attributeValues("gene_id"),
	// features.attributeValues("transcript_id"));
	// System.out.println(WT);

