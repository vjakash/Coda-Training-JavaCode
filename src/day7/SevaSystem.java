package day7;

public class SevaSystem {
	public static void main(String[] args) {
		SevaSystemDept sevaSystemDept=new SevaSystemDept();
		sevaSystemDept.gCommand[0].execute();
		sevaSystemDept.gCommand[1].execute();
	}
}
class SevaSystemDept {
	static Corporation corporation=new Corporation();
	static PoliceStation policeStation=new PoliceStation();
	static Hospital hospital=new Hospital();
	static FoodSafetyDept foodSafetyDept=new FoodSafetyDept();
	GovtCommands gCommand[]= {
							  new GetDeathCertificateCommand(corporation,policeStation,hospital,foodSafetyDept),
							  new GetNewHotelClearanceCertificate(corporation,policeStation,hospital,foodSafetyDept)
							  };
	
}
abstract class GovtCommands{
	 Corporation corporation;
	 PoliceStation policeStation;
	 Hospital hospital;
	 FoodSafetyDept foodSafetyDept;
	public GovtCommands(Corporation corporation, PoliceStation policeStation, Hospital hospital,FoodSafetyDept foodSafetyDept) {
		this.corporation = corporation;
		this.policeStation = policeStation;
		this.hospital = hospital;
		this.foodSafetyDept=foodSafetyDept;
	}
	public abstract void execute();
	
}

class GetDeathCertificateCommand extends GovtCommands{
	public GetDeathCertificateCommand(Corporation corporation, PoliceStation policeStation, Hospital hospital,FoodSafetyDept foodSafetyDept) {
		super(corporation,policeStation,hospital,foodSafetyDept);
	}
	@Override
	public void execute() {
		System.out.println("Death certificate process started");
		corporation.applyDeathCertificate();
		policeStation.getPoliceClearanceCertificate();
		hospital.approveDeathCertificate();
		System.out.println("Death certificate received");
	}
}
class GetNewHotelClearanceCertificate extends GovtCommands{
	public GetNewHotelClearanceCertificate(Corporation corporation, PoliceStation policeStation, Hospital hospital,FoodSafetyDept foodSafetyDept) {
		super(corporation,policeStation,hospital,foodSafetyDept);
	}
	@Override
	public void execute() {
		System.out.println("New hotel clearance certificate process started");
		corporation.applyNewHotelClearance();
		foodSafetyDept.validateApplication();;
		foodSafetyDept.approveNewHotelClearance();
		System.out.println("New hotel clearance certificate received");
	}
}
class Corporation{
	public void applyDeathCertificate() {
		System.out.println("Application for death certificate started");
	}
	public void applyNewHotelClearance() {
		System.out.println("Application for new hotel clearance certificate started");
	}
}
class PoliceStation{
	public void getPoliceClearanceCertificate() {
		System.out.println("Got police clearance certificate");
	}
}
class Hospital{
	public void approveDeathCertificate() {
		System.out.println("Death certificate approved");
	}
}
class FoodSafetyDept{
	public void validateApplication() {
		System.out.println("validation and verification of aplication Done.....");
	}
	public void approveNewHotelClearance() {
		System.out.println("New hotel clearance certificate is approved");
	}
}