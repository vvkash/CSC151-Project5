public class HardwareShah {
    private String processorType;
    private double gpuClockSpeed;
    private double cpuClockSpeed;
    private int numCpuCores;
    private int monitorResolution;
    private boolean overclockChoice;

    public HardwareShah() {
        this.processorType = "";
        this.gpuClockSpeed = 0.0;
        this.cpuClockSpeed = 0.0;
        this.numCpuCores = 0;
        this.monitorResolution = 0;
        this.overclockChoice = false;
    }

    public HardwareShah(String processorType, double gpuClockSpeed, double cpuClockSpeed,
                            int numCpuCores, int monitorResolution, boolean overclockChoice) {
        this.processorType = processorType;
        this.gpuClockSpeed = gpuClockSpeed;
        this.cpuClockSpeed = cpuClockSpeed;
        this.numCpuCores = numCpuCores;
        this.monitorResolution = monitorResolution;
        this.overclockChoice = overclockChoice;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    public void setGpuClockSpeed(double gpuClockSpeed) {
        this.gpuClockSpeed = gpuClockSpeed;
    }

    public void setCpuClockSpeed(double cpuClockSpeed) {
        this.cpuClockSpeed = cpuClockSpeed;
    }

    public void setNumCpuCores(int numCpuCores) {
        this.numCpuCores = numCpuCores;
    }

    public void setMonitorResolution(int monitorResolution) {
        this.monitorResolution = monitorResolution;
    }

    public void setOverclockChoice(boolean overclockChoice) {
        this.overclockChoice = overclockChoice;
    }

    public String getProcessorType() {
        return processorType;
    }

    public String getResolutionString() {
        int width = monitorResolution / 1024;
        int height = monitorResolution % 1024;
        return width + " X " + height;
    }

    public double getMultiplierValue() {
        if (overclockChoice) {
            return 1.5;
        } else {
            return 1.0;
        }
    }

    public double calculatePerformanceScore() {
        double multiplier = getMultiplierValue();
        double score = (gpuClockSpeed * cpuClockSpeed * numCpuCores) * multiplier;
        return score;
    }

    public String getRecommendedQuality() {
        double performanceScore = calculatePerformanceScore();
        if (performanceScore >= 60000.0) {
            return "Ultra Extended";
        } else if (performanceScore >= 40000.0) {
            return "Ultra";
        } else if (performanceScore >= 20000.0) {
            return "High";
        } else if (performanceScore >= 10000.0) {
            return "Low";
        } else {
            return "Unable to Play";
        }
    }

    public boolean getOverclockChoice() {
        return overclockChoice;
    }

    public void displayInformation() {
