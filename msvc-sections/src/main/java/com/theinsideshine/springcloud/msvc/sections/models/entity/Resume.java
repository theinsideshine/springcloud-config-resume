package com.theinsideshine.springcloud.msvc.sections.models.entity;


import com.theinsideshine.springcloud.msvc.sections.models.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "resume_id")
    private List<ResumeUser> resumeUsers;

    @Transient
    private List<User> users;

    public Resume() {
        resumeUsers = new ArrayList<>();
        users = new ArrayList<>();
    }

    @NotBlank
    private String key1;

    @NotBlank
    private String value1;

    @NotBlank
    private String key2;

    @NotBlank
    private String value2;

    @NotBlank
    private String key3;

    @NotBlank
    private String value3;

    @NotBlank
    private String key4;

    @NotBlank
    private String value4;

    @NotBlank
    private String key5;

    @NotBlank
    private String value5;

    @NotBlank
    private String key6;

    @NotBlank
    private String value6;

    @NotBlank
    private String key7;

    @NotBlank
    private String value7;

    @NotBlank
    private String key8;

    @NotBlank
    private String value8;

    @NotBlank
    private String key9;

    @NotBlank
    private String value9;

    @NotBlank
    private String key10;

    @NotBlank
    private String value10;


    @NotBlank
    private String key11;

    @NotBlank
    private String value11;

    @NotBlank
    private String key12;

    @NotBlank
    private String value12;

    @NotBlank
    private String key13;

    @NotBlank
    private String value13;

    @NotBlank
    private String key14;

    @NotBlank
    private String value14;

    private String key15;

    @NotBlank
    private String value15;


    private String key16;

    @NotBlank
    private String value16;

    private String key17;

    @NotBlank
    private String value17;

    private String key18;

    @NotBlank
    private String value18;

    @NotBlank
    private String key19;

    @NotBlank
    @Lob
    private String value19;

    @NotBlank
    private String key20;

    @NotBlank
    private String value20;


    @NotBlank
    private String key21;

    @NotBlank
    private String value21;

    @NotBlank
    private String key22;

    @NotBlank
    private String value22;

    @NotBlank
    private String key23;

    @NotBlank
    private String value23;

    @NotBlank
    private String key24;

    @NotBlank
    private String value24;

    @NotBlank
    private String key25;

    @NotBlank
    private String value25;

    @NotBlank
    private String key26;

    @NotBlank
    private String value26;

    @NotBlank
    private String key27;

    @NotBlank
    private String value27;

    @NotBlank
    private String key28;

    @NotBlank
    private String value28;

    @NotBlank
    private String key29;

    @NotBlank
    private String value29;

    @NotBlank
    private String key30;

    @NotBlank
    private String value30;


    @NotBlank
    private String key31;

    @NotBlank
    private String value31;

    @NotBlank
    private String key32;

    @NotBlank
    private String value32;

    @NotBlank
    private String key33;

    @NotBlank
    private String value33;

    @NotBlank
    private String key34;

    @NotBlank
    private String value34;

    private String key35;

    @NotBlank
    private String value35;

    @NotBlank
    private String key36;

    @NotBlank
    private String value36;

    @NotBlank
    private String key37;

    @NotBlank
    private String value37;

    @NotBlank
    private String key38;

    @NotBlank
    private String value38;

    @NotBlank
    private String key39;

    @NotBlank
    private String value39;

    @NotBlank
    private String key40;

    @NotBlank
    private String value40;


    @NotBlank
    private String key41;

    @NotBlank
    private String value41;

    @NotBlank
    private String key42;

    @NotBlank
    private String value42;

    @NotBlank
    private String key43;

    @NotBlank
    private String value43;

    @NotBlank
    private String key44;

    @NotBlank
    private String value44;

    @NotBlank
    private String key45;

    @NotBlank
    private String value45;

    @NotBlank
    private String key46;

    @NotBlank
    private String value46;

    @NotBlank
    private String key47;

    @NotBlank
    private String value47;

    @NotBlank
    private String key48;

    @NotBlank
    private String value48;

    @NotBlank
    private String key49;

    @NotBlank
    private String value49;


    @NotBlank
    private String key50;

    @NotBlank
    private String value50;


    @NotBlank
    private String key51;

    @NotBlank
    private String value51;

    @NotBlank
    private String key52;

    @NotBlank
    private String value52;

    @NotBlank
    private String key53;

    @NotBlank
    private String value53;

    @NotBlank
    private String key54;

    @NotBlank
    private String value54;

    @NotBlank
    private String key55;

    @NotBlank
    private String value55;


    @NotBlank
    private String key56;

    @NotBlank
    private String value56;

    @NotBlank
    private String key57;

    @NotBlank
    private String value57;

    @NotBlank
    private String key58;

    @NotBlank
    private String value58;

    @NotBlank
    private String key59;

    @NotBlank
    private String value59;

    @NotBlank
    private String key60;

    @NotBlank
    private String value60;


    @NotBlank
    private String key61;

    @NotBlank
    private String value61;

    @NotBlank
    private String key62;

    @NotBlank
    private String value62;

    @NotBlank
    private String key63;

    @NotBlank
    private String value63;

    @NotBlank
    private String key64;

    @NotBlank
    private String value64;

    @NotBlank
    private String key65;

    @NotBlank
    private String value65;


    @NotBlank
    private String key66;

    @NotBlank
    private String value66;

    @NotBlank
    private String key67;

    @NotBlank
    private String value67;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getKey3() {
        return key3;
    }

    public void setKey3(String key3) {
        this.key3 = key3;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    public String getKey4() {
        return key4;
    }

    public void setKey4(String key4) {
        this.key4 = key4;
    }

    public String getValue4() {
        return value4;
    }

    public void setValue4(String value4) {
        this.value4 = value4;
    }

    public String getKey5() {
        return key5;
    }

    public void setKey5(String key5) {
        this.key5 = key5;
    }

    public String getValue5() {
        return value5;
    }

    public void setValue5(String value5) {
        this.value5 = value5;
    }

    public String getKey6() {
        return key6;
    }

    public void setKey6(String key6) {
        this.key6 = key6;
    }

    public String getValue6() {
        return value6;
    }

    public void setValue6(String value6) {
        this.value6 = value6;
    }

    public String getKey7() {
        return key7;
    }

    public void setKey7(String key7) {
        this.key7 = key7;
    }

    public String getValue7() {
        return value7;
    }

    public void setValue7(String value7) {
        this.value7 = value7;
    }

    public String getKey8() {
        return key8;
    }

    public void setKey8(String key8) {
        this.key8 = key8;
    }

    public String getValue8() {
        return value8;
    }

    public void setValue8(String value8) {
        this.value8 = value8;
    }

    public String getKey9() {
        return key9;
    }

    public void setKey9(String key9) {
        this.key9 = key9;
    }

    public String getValue9() {
        return value9;
    }

    public void setValue9(String value9) {
        this.value9 = value9;
    }

    public String getKey10() {
        return key10;
    }

    public void setKey10(String key10) {
        this.key10 = key10;
    }

    public String getValue10() {
        return value10;
    }

    public void setValue10(String value10) {
        this.value10 = value10;
    }

    public String getKey11() {
        return key11;
    }

    public void setKey11(String key11) {
        this.key11 = key11;
    }

    public String getValue11() {
        return value11;
    }

    public void setValue11(String value11) {
        this.value11 = value11;
    }

    public String getKey12() {
        return key12;
    }

    public void setKey12(String key12) {
        this.key12 = key12;
    }

    public String getValue12() {
        return value12;
    }

    public void setValue12(String value12) {
        this.value12 = value12;
    }

    public String getKey13() {
        return key13;
    }

    public void setKey13(String key13) {
        this.key13 = key13;
    }

    public String getValue13() {
        return value13;
    }

    public void setValue13(String value13) {
        this.value13 = value13;
    }

    public String getKey14() {
        return key14;
    }

    public void setKey14(String key14) {
        this.key14 = key14;
    }

    public String getValue14() {
        return value14;
    }

    public void setValue14(String value14) {
        this.value14 = value14;
    }

    public String getKey15() {
        return key15;
    }

    public void setKey15(String key15) {
        this.key15 = key15;
    }

    public String getValue15() {
        return value15;
    }

    public void setValue15(String value15) {
        this.value15 = value15;
    }

    public String getKey16() {
        return key16;
    }

    public void setKey16(String key16) {
        this.key16 = key16;
    }

    public String getValue16() {
        return value16;
    }

    public void setValue16(String value16) {
        this.value16 = value16;
    }

    public String getKey17() {
        return key17;
    }

    public void setKey17(String key17) {
        this.key17 = key17;
    }

    public String getValue17() {
        return value17;
    }

    public void setValue17(String value17) {
        this.value17 = value17;
    }

    public String getKey18() {
        return key18;
    }

    public void setKey18(String key18) {
        this.key18 = key18;
    }

    public String getValue18() {
        return value18;
    }

    public void setValue18(String value18) {
        this.value18 = value18;
    }

    public String getKey19() {
        return key19;
    }

    public void setKey19(String key19) {
        this.key19 = key19;
    }

    public String getValue19() {
        return value19;
    }

    public void setValue19(String value19) {
        this.value19 = value19;
    }

    public String getKey20() {
        return key20;
    }

    public void setKey20(String key20) {
        this.key20 = key20;
    }

    public String getValue20() {
        return value20;
    }

    public void setValue20(String value20) {
        this.value20 = value20;
    }

    public String getKey21() {
        return key21;
    }

    public void setKey21(String key21) {
        this.key21 = key21;
    }

    public String getValue21() {
        return value21;
    }

    public void setValue21(String value21) {
        this.value21 = value21;
    }

    public String getKey22() {
        return key22;
    }

    public void setKey22(String key22) {
        this.key22 = key22;
    }

    public String getValue22() {
        return value22;
    }

    public void setValue22(String value22) {
        this.value22 = value22;
    }

    public String getKey23() {
        return key23;
    }

    public void setKey23(String key23) {
        this.key23 = key23;
    }

    public String getValue23() {
        return value23;
    }

    public void setValue23(String value23) {
        this.value23 = value23;
    }

    public String getKey24() {
        return key24;
    }

    public void setKey24(String key24) {
        this.key24 = key24;
    }

    public String getValue24() {
        return value24;
    }

    public void setValue24(String value24) {
        this.value24 = value24;
    }

    public String getKey25() {
        return key25;
    }

    public void setKey25(String key25) {
        this.key25 = key25;
    }

    public String getValue25() {
        return value25;
    }

    public void setValue25(String value25) {
        this.value25 = value25;
    }

    public String getKey26() {
        return key26;
    }

    public void setKey26(String key26) {
        this.key26 = key26;
    }

    public String getValue26() {
        return value26;
    }

    public void setValue26(String value26) {
        this.value26 = value26;
    }

    public String getKey27() {
        return key27;
    }

    public void setKey27(String key27) {
        this.key27 = key27;
    }

    public String getValue27() {
        return value27;
    }

    public void setValue27(String value27) {
        this.value27 = value27;
    }

    public String getKey28() {
        return key28;
    }

    public void setKey28(String key28) {
        this.key28 = key28;
    }

    public String getValue28() {
        return value28;
    }

    public void setValue28(String value28) {
        this.value28 = value28;
    }

    public String getKey29() {
        return key29;
    }

    public void setKey29(String key29) {
        this.key29 = key29;
    }

    public String getValue29() {
        return value29;
    }

    public void setValue29(String value29) {
        this.value29 = value29;
    }

    public String getKey30() {
        return key30;
    }

    public void setKey30(String key30) {
        this.key30 = key30;
    }

    public String getValue30() {
        return value30;
    }

    public void setValue30(String value30) {
        this.value30 = value30;
    }

    public String getKey31() {
        return key31;
    }

    public void setKey31(String key31) {
        this.key31 = key31;
    }

    public String getValue31() {
        return value31;
    }

    public void setValue31(String value31) {
        this.value31 = value31;
    }

    public String getKey32() {
        return key32;
    }

    public void setKey32(String key32) {
        this.key32 = key32;
    }

    public String getValue32() {
        return value32;
    }

    public void setValue32(String value32) {
        this.value32 = value32;
    }

    public String getKey33() {
        return key33;
    }

    public void setKey33(String key33) {
        this.key33 = key33;
    }

    public String getValue33() {
        return value33;
    }

    public void setValue33(String value33) {
        this.value33 = value33;
    }

    public String getKey34() {
        return key34;
    }

    public void setKey34(String key34) {
        this.key34 = key34;
    }

    public String getValue34() {
        return value34;
    }

    public void setValue34(String value34) {
        this.value34 = value34;
    }

    public String getKey35() {
        return key35;
    }

    public void setKey35(String key35) {
        this.key35 = key35;
    }

    public String getValue35() {
        return value35;
    }

    public void setValue35(String value35) {
        this.value35 = value35;
    }

    public String getKey36() {
        return key36;
    }

    public void setKey36(String key36) {
        this.key36 = key36;
    }

    public String getValue36() {
        return value36;
    }

    public void setValue36(String value36) {
        this.value36 = value36;
    }

    public String getKey37() {
        return key37;
    }

    public void setKey37(String key37) {
        this.key37 = key37;
    }

    public String getValue37() {
        return value37;
    }

    public void setValue37(String value37) {
        this.value37 = value37;
    }

    public String getKey38() {
        return key38;
    }

    public void setKey38(String key38) {
        this.key38 = key38;
    }

    public String getValue38() {
        return value38;
    }

    public void setValue38(String value38) {
        this.value38 = value38;
    }

    public String getKey39() {
        return key39;
    }

    public void setKey39(String key39) {
        this.key39 = key39;
    }

    public String getValue39() {
        return value39;
    }

    public void setValue39(String value39) {
        this.value39 = value39;
    }

    public String getKey40() {
        return key40;
    }

    public void setKey40(String key40) {
        this.key40 = key40;
    }

    public String getValue40() {
        return value40;
    }

    public void setValue40(String value40) {
        this.value40 = value40;
    }

    public String getKey41() {
        return key41;
    }

    public void setKey41(String key41) {
        this.key41 = key41;
    }

    public String getValue41() {
        return value41;
    }

    public void setValue41(String value41) {
        this.value41 = value41;
    }

    public String getKey42() {
        return key42;
    }

    public void setKey42(String key42) {
        this.key42 = key42;
    }

    public String getValue42() {
        return value42;
    }

    public void setValue42(String value42) {
        this.value42 = value42;
    }

    public String getKey43() {
        return key43;
    }

    public void setKey43(String key43) {
        this.key43 = key43;
    }

    public String getValue43() {
        return value43;
    }

    public void setValue43(String value43) {
        this.value43 = value43;
    }

    public String getKey44() {
        return key44;
    }

    public void setKey44(String key44) {
        this.key44 = key44;
    }

    public String getValue44() {
        return value44;
    }

    public void setValue44(String value44) {
        this.value44 = value44;
    }

    public String getKey45() {
        return key45;
    }

    public void setKey45(String key45) {
        this.key45 = key45;
    }

    public String getValue45() {
        return value45;
    }

    public void setValue45(String value45) {
        this.value45 = value45;
    }

    public String getKey46() {
        return key46;
    }

    public void setKey46(String key46) {
        this.key46 = key46;
    }

    public String getValue46() {
        return value46;
    }

    public void setValue46(String value46) {
        this.value46 = value46;
    }

    public String getKey47() {
        return key47;
    }

    public void setKey47(String key47) {
        this.key47 = key47;
    }

    public String getValue47() {
        return value47;
    }

    public void setValue47(String value47) {
        this.value47 = value47;
    }

    public String getKey48() {
        return key48;
    }

    public void setKey48(String key48) {
        this.key48 = key48;
    }

    public String getValue48() {
        return value48;
    }

    public void setValue48(String value48) {
        this.value48 = value48;
    }

    public String getKey49() {
        return key49;
    }

    public void setKey49(String key49) {
        this.key49 = key49;
    }

    public String getKey50() {
        return key50;
    }

    public void setKey50(String key50) {
        this.key50 = key50;
    }

    public String getValue49() {
        return value49;
    }

    public void setValue49(String value49) {
        this.value49 = value49;
    }

    public String getValue50() {
        return value50;
    }

    public void setValue50(String value50) {
        this.value50 = value50;
    }

    public String getKey51() {
        return key51;
    }

    public void setKey51(String key51) {
        this.key51 = key51;
    }

    public String getValue51() {
        return value51;
    }

    public void setValue51(String value51) {
        this.value51 = value51;
    }

    public String getKey52() {
        return key52;
    }

    public void setKey52(String key52) {
        this.key52 = key52;
    }

    public String getValue52() {
        return value52;
    }

    public void setValue52(String value52) {
        this.value52 = value52;
    }

    public String getKey53() {
        return key53;
    }

    public void setKey53(String key53) {
        this.key53 = key53;
    }

    public String getValue53() {
        return value53;
    }

    public void setValue53(String value53) {
        this.value53 = value53;
    }

    public String getKey54() {
        return key54;
    }

    public void setKey54(String key54) {
        this.key54 = key54;
    }

    public String getValue54() {
        return value54;
    }

    public void setValue54(String value54) {
        this.value54 = value54;
    }

    public String getKey55() {
        return key55;
    }

    public void setKey55(String key55) {
        this.key55 = key55;
    }

    public String getValue55() {
        return value55;
    }

    public void setValue55(String value55) {
        this.value55 = value55;
    }

    public String getKey56() {
        return key56;
    }

    public void setKey56(String key56) {
        this.key56 = key56;
    }

    public String getValue56() {
        return value56;
    }

    public void setValue56(String value56) {
        this.value56 = value56;
    }

    public String getKey57() {
        return key57;
    }

    public void setKey57(String key57) {
        this.key57 = key57;
    }

    public String getValue57() {
        return value57;
    }

    public void setValue57(String value57) {
        this.value57 = value57;
    }

    public String getKey58() {
        return key58;
    }

    public void setKey58(String key58) {
        this.key58 = key58;
    }

    public String getValue58() {
        return value58;
    }

    public void setValue58(String value58) {
        this.value58 = value58;
    }

    public String getKey59() {
        return key59;
    }

    public void setKey59(String key59) {
        this.key59 = key59;
    }

    public String getValue59() {
        return value59;
    }

    public void setValue59(String value59) {
        this.value59 = value59;
    }

    public String getKey60() {
        return key60;
    }

    public void setKey60(String key60) {
        this.key60 = key60;
    }

    public String getValue60() {
        return value60;
    }

    public void setValue60(String value60) {
        this.value60 = value60;
    }

    public String getKey61() {
        return key61;
    }

    public void setKey61(String key61) {
        this.key61 = key61;
    }

    public String getValue61() {
        return value61;
    }

    public void setValue61(String value61) {
        this.value61 = value61;
    }

    public String getKey62() {
        return key62;
    }

    public void setKey62(String key62) {
        this.key62 = key62;
    }

    public String getValue62() {
        return value62;
    }

    public void setValue62(String value62) {
        this.value62 = value62;
    }

    public String getKey63() {
        return key63;
    }

    public void setKey63(String key63) {
        this.key63 = key63;
    }

    public String getValue63() {
        return value63;
    }

    public void setValue63(String value63) {
        this.value63 = value63;
    }

    public String getKey64() {
        return key64;
    }

    public void setKey64(String key64) {
        this.key64 = key64;
    }

    public String getValue64() {
        return value64;
    }

    public void setValue64(String value64) {
        this.value64 = value64;
    }

    public String getKey65() {
        return key65;
    }

    public void setKey65(String key65) {
        this.key65 = key65;
    }

    public String getValue65() {
        return value65;
    }

    public void setValue65(String value65) {
        this.value65 = value65;
    }

    public String getKey66() {
        return key66;
    }

    public void setKey66(String key66) {
        this.key66 = key66;
    }

    public String getValue66() {
        return value66;
    }

    public void setValue66(String value66) {
        this.value66 = value66;
    }

    public String getKey67() {
        return key67;
    }

    public void setKey67(String key67) {
        this.key67 = key67;
    }

    public String getValue67() {
        return value67;
    }

    public void setValue67(String value67) {
        this.value67 = value67;
    }

    public void addResumeUser(ResumeUser resumeUser) {
        resumeUsers.add(resumeUser);
    }

    public void removeResumeUser(ResumeUser resumeUser) {
        resumeUsers.remove(resumeUser); // aca use la comparacion sobreescribir en cursoUsers el equals
    }
    public List<ResumeUser> getResumeUsers() {
        return resumeUsers;
    }

    public void setAboutUsers(List<ResumeUser> resumeUser) {
        this.resumeUsers = resumeUser;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
