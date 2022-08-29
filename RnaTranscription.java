import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class RnaTranscription {
    private String dnaStrand;
    public RnaTranscription(String dnaStrand) {
		this.dnaStrand = dnaStrand;
	}
    public RnaTranscription() {
		
	}
    String transcribe(String dnaStrand) {
        String rnaStrand = decodeDNA(dnaStrand);
		return rnaStrand;
    }
    public String getDnaStrand() {
		return this.dnaStrand;
	}
	public void setDnaStrand(String dnaStrand) {
		this.dnaStrand = dnaStrand;
	}
    private String decodeDNA(String dnaStrand) {
		
		if(dnaStrand.length() == 1) {
			switch (dnaStrand) {
			case "G": {
				
				return "C";
			}
			case "C": {
				
				return "G";
			}
			case "T": {
				
				return "A";
			}
			case "A": {
				
				return "U";
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + dnaStrand);
			}
		}else {
			return decodeDnaSequence(dnaStrand);
		}
	}
    private String decodeDnaSequence(String dnaStrand)throws IllegalArgumentException {
		StringBuilder rnaStrand = new StringBuilder();
		List<String> str = Arrays.stream(dnaStrand.split(""))
									.collect(Collectors.toList());
		for (String s : str) {
			if(s.equals("G"))rnaStrand.append("C");
			else if(s.equals("C"))rnaStrand.append("G");
			else if(s.equals("T"))rnaStrand.append("A");
			else if(s.equals("A"))rnaStrand.append("U");
			
		}
		return rnaStrand.toString();
	}
}
