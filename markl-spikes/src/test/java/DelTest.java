import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class DelTest {
	
	@Test
	public void toSQL() {
        final List<MeterParam> inMeter = Arrays.asList(
                new MeterParam(G2SDeviceClass.BONUS, G2SMeterType.DEVICE, G2SMeterName.G2S_nonCashInAmt),
                new MeterParam(G2SDeviceClass.BONUS, G2SMeterType.DEVICE, G2SMeterName.G2S_promoInAmt),
                new MeterParam(G2SDeviceClass.COIN_ACCEPTOR, G2SMeterType.DEVICE, G2SMeterName.G2S_currencyInAmt),
                new MeterParam(G2SDeviceClass.DFT, G2SMeterType.DEVICE, G2SMeterName.G2S_cashableInAmt),
                new MeterParam(G2SDeviceClass.DFT, G2SMeterType.DEVICE, G2SMeterName.G2S_nonCashInAmt),
                new MeterParam(G2SDeviceClass.DFT, G2SMeterType.DEVICE, G2SMeterName.G2S_promoInAmt),
                new MeterParam(G2SDeviceClass.NOTE_ACCEPTOR, G2SMeterType.DEVICE, G2SMeterName.G2S_currencyInAmt),
                new MeterParam(G2SDeviceClass.SMARTCARD, G2SMeterType.DEVICE, G2SMeterName.G2S_cashableInAmt),
                new MeterParam(G2SDeviceClass.SMARTCARD, G2SMeterType.DEVICE, G2SMeterName.G2S_nonCashInAmt),
                new MeterParam(G2SDeviceClass.SMARTCARD, G2SMeterType.DEVICE, G2SMeterName.G2S_promoInAmt),
                new MeterParam(G2SDeviceClass.VOUCHER, G2SMeterType.DEVICE, G2SMeterName.G2S_cashableInAmt),
                new MeterParam(G2SDeviceClass.VOUCHER, G2SMeterType.DEVICE, G2SMeterName.G2S_cashableSysInAmt),
                new MeterParam(G2SDeviceClass.VOUCHER, G2SMeterType.DEVICE, G2SMeterName.G2S_nonCashInAmt),
                new MeterParam(G2SDeviceClass.VOUCHER, G2SMeterType.DEVICE, G2SMeterName.G2S_nonCashSysInAmt),
                new MeterParam(G2SDeviceClass.VOUCHER, G2SMeterType.DEVICE, G2SMeterName.G2S_promoInAmt),
                new MeterParam(G2SDeviceClass.VOUCHER, G2SMeterType.DEVICE, G2SMeterName.G2S_promoSysInAmt),
                new MeterParam(G2SDeviceClass.WAT, G2SMeterType.DEVICE, G2SMeterName.G2S_cashableInAmt),
                new MeterParam(G2SDeviceClass.WAT, G2SMeterType.DEVICE, G2SMeterName.G2S_nonCashInAmt),
                new MeterParam(G2SDeviceClass.WAT, G2SMeterType.DEVICE, G2SMeterName.G2S_promoInAmt)
                );
        
        final List<MeterParam> outMeter = Arrays.asList(
                new MeterParam(G2SDeviceClass.DFT, G2SMeterType.DEVICE, G2SMeterName.G2S_cashableOutAmt),
                new MeterParam(G2SDeviceClass.DFT, G2SMeterType.DEVICE, G2SMeterName.G2S_nonCashOutAmt),
                new MeterParam(G2SDeviceClass.DFT, G2SMeterType.DEVICE, G2SMeterName.G2S_promoOutAmt),
                new MeterParam(G2SDeviceClass.HAND_PAY, G2SMeterType.DEVICE, G2SMeterName.G2S_cashableOutAmt),
                new MeterParam(G2SDeviceClass.HAND_PAY, G2SMeterType.DEVICE, G2SMeterName.G2S_nonCashOutAmt),
                new MeterParam(G2SDeviceClass.HAND_PAY, G2SMeterType.DEVICE, G2SMeterName.G2S_promoOutAmt),
                new MeterParam(G2SDeviceClass.HOPPER, G2SMeterType.DEVICE, G2SMeterName.G2S_currencyOutAmt),
                new MeterParam(G2SDeviceClass.NOTE_DISPENSER, G2SMeterType.DEVICE, G2SMeterName.G2S_currencyOutAmt),
                new MeterParam(G2SDeviceClass.SMARTCARD, G2SMeterType.DEVICE, G2SMeterName.G2S_cashableOutAmt),
                new MeterParam(G2SDeviceClass.SMARTCARD, G2SMeterType.DEVICE, G2SMeterName.G2S_nonCashOutAmt),
                new MeterParam(G2SDeviceClass.SMARTCARD, G2SMeterType.DEVICE, G2SMeterName.G2S_promoOutAmt),
                new MeterParam(G2SDeviceClass.VOUCHER, G2SMeterType.DEVICE, G2SMeterName.G2S_cashableOutAmt),
                new MeterParam(G2SDeviceClass.VOUCHER, G2SMeterType.DEVICE, G2SMeterName.G2S_nonCashOutAmt),
                new MeterParam(G2SDeviceClass.VOUCHER, G2SMeterType.DEVICE, G2SMeterName.G2S_promoOutAmt),
                new MeterParam(G2SDeviceClass.VOUCHER, G2SMeterType.DEVICE, G2SMeterName.G2S_cashableSysOutAmt), /* */
                new MeterParam(G2SDeviceClass.VOUCHER, G2SMeterType.DEVICE, G2SMeterName.G2S_nonCashSysOutAmt), /* */
                new MeterParam(G2SDeviceClass.VOUCHER, G2SMeterType.DEVICE, G2SMeterName.G2S_promoSysOutAmt), /* */
                new MeterParam(G2SDeviceClass.WAT, G2SMeterType.DEVICE, G2SMeterName.G2S_cashableOutAmt),
                new MeterParam(G2SDeviceClass.WAT, G2SMeterType.DEVICE, G2SMeterName.G2S_nonCashOutAmt),
                new MeterParam(G2SDeviceClass.WAT, G2SMeterType.DEVICE, G2SMeterName.G2S_promoOutAmt)
                );

final List<MeterParam> turnoverMeter = Arrays.asList(
                new MeterParam(G2SDeviceClass.CABINET, G2SMeterType.DEVICE, G2SMeterName.G2S_wageredCashableAmt),
                new MeterParam(G2SDeviceClass.CABINET, G2SMeterType.DEVICE, G2SMeterName.G2S_wageredNonCashAmt),
                new MeterParam(G2SDeviceClass.CABINET, G2SMeterType.DEVICE, G2SMeterName.G2S_wageredPromoAmt)
                );

final List<MeterParam> totalGamePaidWinsMeter = Arrays.asList(
                new MeterParam(G2SDeviceClass.CABINET, G2SMeterType.DEVICE, G2SMeterName.G2S_egmPaidGameWonAmt),
                new MeterParam(G2SDeviceClass.CABINET, G2SMeterType.DEVICE, G2SMeterName.G2S_handPaidGameWonAmt),
                new MeterParam(G2SDeviceClass.CABINET, G2SMeterType.DEVICE, G2SMeterName.G2S_egmPaidProgWonAmt),
                new MeterParam(G2SDeviceClass.CABINET, G2SMeterType.DEVICE, G2SMeterName.G2S_handPaidProgWonAmt),
                new MeterParam(G2SDeviceClass.CABINET, G2SMeterType.DEVICE, G2SMeterName.G2S_cardedProgWonAmt),
                new MeterParam(G2SDeviceClass.CABINET, G2SMeterType.DEVICE, G2SMeterName.G2S_egmPaidBonusWonAmt),
                new MeterParam(G2SDeviceClass.CABINET, G2SMeterType.DEVICE, G2SMeterName.G2S_handPaidBonusWonAmt),
                new MeterParam(G2SDeviceClass.CABINET, G2SMeterType.DEVICE, G2SMeterName.G2S_egmPaidBonusNonWonAmt)
                );

final List<MeterParam> gamesMeterSinceInitialization = Arrays.asList(
                new MeterParam(G2SDeviceClass.CABINET, G2SMeterType.CLASS, G2SMeterName.G2S_gamesSinceInitCnt)
                );
        
        System.out.println(getQuery(outMeter));
	}
	
    private String getQuery(List<MeterParam> params) {
        final StringBuffer sb = new StringBuffer();
        
        sb.append("SELECT SUM(meter_value) FROM meter WHERE (");
        
        for (int i = 0; i < params.size(); i++) {
            final MeterParam param = params.get(i);
            if (i != 0) {
                sb.append(" OR ");
            }
            sb.append("(device_Class = '" + param.getDeviceClass() + "' AND");
            sb.append(" meter_Type = '" + param.getMeterType() + "' AND");
            sb.append(" meter_Name = '" + param.getMeterName() + "')");
        }
        sb.append(")");
        
        return sb.toString();
    }
	
	private class G2SMeterType {
	    
	    private G2SMeterType() {}
	    
	    public static final String DEVICE = "DEVICE";
	    public static final String CLASS = "CLASS";
	}

	
	private class G2SDeviceClass {
	    
	    private G2SDeviceClass() {}
	    
	    public static final String CABINET = "Cabinet";
	    public static final String COIN_ACCEPTOR = "CoinAcceptor";
	    public static final String NOTE_ACCEPTOR = "NoteAcceptor";
	    public static final String NOTE_DISPENSER = "NoteDispenser";
	    public static final String VOUCHER = "Voucher";
	    public static final String WAT = "Wat";
	    public static final String HOPPER = "Hopper";
	    public static final String HAND_PAY = "HandPay";
	    public static final String BONUS = "Bonus";
	    /* extension */
	    public static final String SMARTCARD = "SmartCard";
	    public static final String DFT = "Dft";
	}
	
	private class G2SMeterName {

	    private G2SMeterName() {}

	    public static final String G2S_gamesSinceInitCnt = "G2S_gamesSinceInitCnt"; 

	    public static final String G2S_currencyInAmt = "G2S_currencyInAmt";
	    
	    public static final String G2S_currencyOutAmt = "G2S_currencyOutAmt";

	    public static final String G2S_cashableInAmt = "G2S_cashableInAmt";
	    
	    public static final String G2S_cashableOutAmt = "G2S_cashableOutAmt";
	    
	    public static final String G2S_cashableSysInAmt = "G2S_cashableSysInAmt";
	    
	    public static final String G2S_cashableSysOutAmt = "G2S_cashableSysOutAmt";
	    
	    public static final String G2S_nonCashInAmt = "G2S_nonCashInAmt";
	    
	    public static final String G2S_nonCashOutAmt = "G2S_nonCashOutAmt";
	    
	    public static final String G2S_nonCashSysInAmt = "G2S_nonCashSysInAmt";
	    
	    public static final String G2S_nonCashSysOutAmt = "G2S_nonCashSysOutAmt";
	    
	    public static final String G2S_promoInAmt = "G2S_promoInAmt";

	    public static final String G2S_promoOutAmt = "G2S_promoOutAmt";
	    
	    public static final String G2S_promoSysInAmt = "G2S_promoSysInAmt";
	    
	    public static final String G2S_promoSysOutAmt = "G2S_promoSysOutAmt";
	    
	    public static final String G2S_wageredCashableAmt = "G2S_wageredCashableAmt";
	    
	    public static final String G2S_wageredPromoAmt = "G2S_wageredPromoAmt";
	    
	    public static final String G2S_wageredNonCashAmt = "G2S_wageredNonCashAmt";
	    
	    public static final String G2S_cardedWageredNonCashAmt = "G2S_cardedWageredNonCashAmt";
	    
	    public static final String G2S_cardedWageredCashableAmt = "G2S_cardedWageredCashableAmt";
	    
	    public static final String G2S_cardedWageredPromoAmt = "G2S_cardedWageredPromoAmt";
	    
	    public static final String G2S_egmPaidGameWonAmt = "G2S_egmPaidGameWonAmt";
	    
	    public static final String G2S_handPaidGameWonAmt = "G2S_handPaidGameWonAmt";
	    
	    public static final String G2S_cardedPaidGameWonAmt = "G2S_cardedPaidGameWonAmt";
	    
	    public static final String G2S_egmPaidProgWonAmt = "G2S_egmPaidProgWonAmt";
	    
	    public static final String G2S_handPaidProgWonAmt = "G2S_handPaidProgWonAmt";
	    
	    public static final String G2S_cardedProgWonAmt = "G2S_cardedProgWonAmt";
	    
	    public static final String G2S_egmPaidBonusWonAmt = "G2S_egmPaidBonusWonAmt";
	    
	    public static final String G2S_handPaidBonusWonAmt = "G2S_handPaidBonusWonAmt";
	    
	    public static final String G2S_egmPaidBonusNonWonAmt = "G2S_egmPaidBonusNonWonAmt";
	    
	    public static final String G2S_cardedBonusWonAmt = "G2S_cardedBonusWonAmt";
	    
	    public static final String G2S_cardedBonusNonWonAmt = "G2S_cardedBonusNonWonAmt";
	    
	}
	
	
    private class MeterParam {
        private String deviceClass;
        private String meterType;
        private String meterName;
        
        /**
         * @param deviceClass
         * @param meterType
         * @param meterName
         */
        public MeterParam(String deviceClass, String meterType, String meterName) {
            super();
            this.deviceClass = deviceClass;
            this.meterType = meterType;
            this.meterName = meterName;
        }
        
        /**
         * @return the deviceClass
         */
        public String getDeviceClass() {
            return deviceClass;
        }
        /**
         * @return the meterType
         */
        public String getMeterType() {
            return meterType;
        }
        /**
         * @return the meterName
         */
        public String getMeterName() {
            return meterName;
        }
    }

}
