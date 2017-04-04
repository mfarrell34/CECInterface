package cec;

public enum CECUserControlCode {

    Select                      (0x00),
    Up                          (0x01),
    Down                        (0x02),
    Left                        (0x03),
    Right                       (0x04),
    RightUp                     (0x05),
    RightDown                   (0x06),
    LeftUp                      (0x07),
    LeftDown                    (0x08),
    RootMenu                    (0x09),
    SetupMenu                   (0x0A),
    ContentsMenu                (0x0B),
    FavoriteMenu                (0x0C),
    Exit                        (0x0D),
			  // reserved: 0x0E, 0x0F
    TopMenu                     (0x10),
    DVDMenu                     (0x11),
			  // reserved: 0x12 ... 0x1C
    NumberEntryMode             (0x1D),
    Number11                    (0x1E),
    Number12                    (0x1F),
    Number0                     (0x20),
    Number1                     (0x21),
    Number2                     (0x22),
    Number3                     (0x23),
    Number4                     (0x24),
    Number5                     (0x25),
    Number6                     (0x26),
    Number7                     (0x27),
    Number8                     (0x28),
    Number9                     (0x29),
    Dot                         (0x2A),
    Enter                       (0x2B),
    Clear                       (0x2C),
    NextFavorite                (0x2F),
    ChannelUp                   (0x30),
    ChannelDown                 (0x31),
    PreviousChannel             (0x32),
    SoundSelect                 (0x33),
    InputSelect                 (0x34),
    DisplayInformation          (0x35),
    Help                        (0x36),
    PageUp                      (0x37),
    PageDown                    (0x38),
			  // reserved: 0x39 ... 0x3F
    Power                       (0x40),
    VolumeUp                    (0x41),
    VolumeDown                  (0x42),
    Mute                        (0x43),
    Play                        (0x44),
    Stop                        (0x45),
    Pause                       (0x46),
    Record                      (0x47),
    Rewind                      (0x48),
    FastForward                 (0x49),
    Eject                       (0x4A),
    Forward                     (0x4B),
    Backward                    (0x4C),
    StopRecord                  (0x4D),
    PauseRecord                 (0x4E),
			  // reserved: 0x4F
    Angle                       (0x50),
    SubPicture                  (0x51),
    VideoOnDemand               (0x52),
    ElectronicProgramGuide      (0x53),
    TimerProgramming            (0x54),
    InitialConfiguration        (0x55),
    SelectBroadcastType         (0x56),
    SelectSoundPresentation     (0x57),
			  // reserved: 0x58 ... 0x5F
    PlayFunction                (0x60),
    PausePlayFunction           (0x61),
    RecordFunction              (0x62),
    PauseRecordFunction         (0x63),
    StopFunction                (0x64),
    MuteFunction                (0x65),
    RestoreVolumeFunction       (0x66),
    TuneFunction                (0x67),
    SelectMediaFunction         (0x68),
    SelectAVInputFunction       (0x69),
    SelectAudioInputFunction    (0x6A),
    PowerToggleFunction         (0x6B),
    PowerOffFunction            (0x6C),
    PowerOnFunction             (0x6D),
			  // reserved: 0x6E ... 0x70
    F1_Blue                     (0x71),
    F2_Red                      (0X72),
    F3_Green                    (0x73),
    F4_Yellow                   (0x74),
    F5                          (0x75),
    Data                        (0x76),
			  // reserved: 0x77 ... 0xFF
    ANReturn                    (0x91), // return (Samsung)
    ANChannelsList              (0x96), // channels list (Samsung)
    Max                         (0x96),
    Unknown                     (0xFF);
    
    private int code;
    
    private CECUserControlCode(int code) {
    	this.code = code;
    }
    
    public int getControlCode() {
    	return this.code;
    }
}

