package bio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.biojava3.genome.parsers.gff.FeatureI;
import org.biojava3.genome.parsers.gff.FeatureList;
import org.biojava3.genome.parsers.gff.GeneMarkGTFReader;
import org.biojava3.genome.parsers.gff.Location;

public class SpllicingVariant2 {

	public static void main(String[] args) throws Exception {

		FeatureList features = (FeatureList) GeneMarkGTFReader
				.read("/Users/admin/Dropbox/workspace/bio/testWT.gtf");
		Iterator<FeatureI> featureIterator = features.iterator();
		FeatureI rowWT = null;

		// System.out.println(features.attributeValues("\"gene_id"));
		HashMap<String, HashSet<String>> WT = new HashMap<>();
		HashMap<String, Location> WT2 = new HashMap<>();
		while (featureIterator.hasNext()) {
			rowWT = featureIterator.next();
			String gene_id = rowWT.getAttribute("\"gene_id");
			String transcript_id = rowWT.getAttribute("transcript_id");
			if (WT.containsKey(gene_id) != true) {
				WT.put(gene_id, new HashSet<String>());
			}
			WT.get(gene_id).add(transcript_id);

			Location WTloc = rowWT.location();
			if (WT2.containsKey(transcript_id) != true) {
				WT2.put(transcript_id, WTloc);
			}
		}

		System.out.println(WT);
		System.out.println(WT2);
		FeatureList features1 = (FeatureList) GeneMarkGTFReader
				.read("/Users/admin/Dropbox/workspace/bio/testKI.gtf");
		Iterator<FeatureI> featureIterator2 = features1.iterator();
		FeatureI rowKI = null;
		HashMap<String, HashSet<String>> KI = new HashMap<>();
		HashMap<String, Location> KI2 = new HashMap<>();
		while (featureIterator2.hasNext()) {
			rowKI = featureIterator2.next();
			String gene_id = rowKI.getAttribute("\"gene_id");
			String transcript_id = rowKI.getAttribute("transcript_id");
			if (KI.containsKey(gene_id) != true) {
				KI.put(gene_id, new HashSet<String>());

			}
			KI.get(gene_id).add(transcript_id);
			Location KIloc = rowKI.location();
			if (KI2.containsKey(transcript_id) != true) {
				KI2.put(transcript_id, KIloc);
			}

		}
		System.out.println(KI);
		System.out.println(KI2);
		// すべてのトランスクリプトの間で比較したい

		while (featureIterator1.hasNext()) {


		for (String key : WT2.keySet()) {
			WT_traloc = WT2.get(key);
		System.out.println(WT_traloc);
		}

		System.out.println("desfawdaw");


// data1(A)のときdataKI(最初から最後まで)のdata1(最初から最後まで)の総当り

				if(
				WT_traloc.overlaps(KI_tranloc)){
		System.out.println(WT.get(WT_traloc));
	//}
		}}




	//}
		}}
	//



// HashSet<String> data = null;
// for (String key : WT.keySet()) {
// data = WT.get(key);

// やりたいこと

// 近いLocationで
// transcriptの数が一緒かどうか比較
// 長さがちがうかどうか
// exonの数が違うかどうか
// Locationなどで
// データベースで書いたほうが早いか
// System.out.println(data3); }

// MAPはkey重複を許さない.(絶対不可能).上書きされる
// HashMap<Collection<String>, Collection<String>> WT = new HashMap<>();
// WT.put(features.attributeValues("gene_id"),
// features.attributeValues("transcript_id"));
// なぜかgene_idがnull,どんな形while構文、for文で抽出してもnull
// バグ？
// System.out.println(WT);

