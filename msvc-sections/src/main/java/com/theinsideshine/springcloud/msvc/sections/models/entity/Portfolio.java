package com.theinsideshine.springcloud.msvc.sections.models.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="portfolios")
public class Portfolio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @NotBlank
    private String key15;

    @NotBlank
    private String value15;

    @NotBlank
    private String key16;

    @NotBlank
    private String value16;

    @NotBlank
    private String key17;

    @NotBlank
    private String value17;

    @NotBlank
    private String key18;

    @NotBlank
    private String value18;

    @NotBlank
    private String key19;

    @NotBlank
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
}
