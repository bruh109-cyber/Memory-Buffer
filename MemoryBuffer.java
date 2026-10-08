public class MemoryBuffer {
    public String sectorLabel;

    private int rawDataPayload;

    public MemoryBuffer(String label, int initialData){
        this.sectorLabel = label;
        this.rawDataPayload = initialData;
    }

    public void safeUpdatePayLoad(int newData, String securityToken){
        if(!securityToken.equals("ADMIN_SYS_2026")){
            System.out.println("[DENIED]: Unauthorized token! Memory protection active.");
            return;
        }
        if(newData < 0 || newData > 65535) {
            System.out.println("[REJECTED]: Payload size out of bounds (16-bit limit violation ).");
            return;
         }  

        this.rawDataPayload = newData;
        System.out.println("[SUCCESS]: Private memeory payload updated to: " + this.rawDataPayload );
    }
}
