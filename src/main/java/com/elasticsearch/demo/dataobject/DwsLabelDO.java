package com.elasticsearch.demo.dataobject;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Document(indexName = "dws_label", shards = 3, indexStoreType = "niofs", refreshInterval = "1800s")
public class DwsLabelDO implements Serializable {
    @Id
    private String id;
    private String userId;
    @Field(type = FieldType.Keyword)
    private String memberId;
    @Field(type = FieldType.Keyword)
    private String shopId;
    @Field(type = FieldType.Keyword)
    private String year;
    @Field(type = FieldType.Keyword)
    private String quarter;
    @Field(type = FieldType.Keyword)
    private String month;
    @Field(type = FieldType.Keyword)
    private String sex;
    @Field(type = FieldType.Keyword)
    private String cityLevel;
    @Field(type = FieldType.Keyword)
    private String isHaveBaby;
    @Field(type = FieldType.Keyword)
    private String isHavePet;
    @Field(type = FieldType.Keyword)
    private String receivingAddressProvince;
    @Field(type = FieldType.Keyword)
    private String receivingAddressCity;
    @Field(type = FieldType.Keyword)
    private String receivingAddressDistrict;
    @Field(type = FieldType.Keyword)
    private String receivingAddressStreet;
    private String receivingAddressCommunity;
    @Field(type = FieldType.Keyword)
    private String shoppingTime;
    @Field(type = FieldType.Keyword)
    private String shoppingTimePoint;
    @Field(type = FieldType.Keyword)
    private String preferenceOfPromotion;
    @Field(type = FieldType.Keyword)
    private String platformList;
    @Field(type = FieldType.Keyword)
    private String preferenceOfPlatform;
    @Field(type = FieldType.Keyword)
    private String preferenceOfTransactionType;
    @Field(type = FieldType.Keyword)
    private String lastPurchaseTime;
    @Field(type = FieldType.Keyword)
    private String lastPurchaseTimeLabel;
    @Field(type = FieldType.Keyword)
    private String rfmModelResult;
    @Field(type = FieldType.Keyword)
    private String distanceEarliestToday;
    @Field(type = FieldType.Keyword)
    private String daysMeanBuyNum;
    @Field(type = FieldType.Keyword)
    private String daysMeanBuy;
    @Field(type = FieldType.Keyword)
    private String numPerShopPrefer;
    @Field(type = FieldType.Keyword)
    private String itemCount1Year;
    @Field(type = FieldType.Keyword)
    private String intervalDays1Year;
    @Field(type = FieldType.Keyword)
    private String sumSaleMonth;
    @Field(type = FieldType.Keyword)
    private String sumSaleQuarter;
    @Field(type = FieldType.Keyword)
    private String sumSale30Days;
    @Field(type = FieldType.Keyword)
    private String sumSale90Days;
    @Field(type = FieldType.Keyword)
    private String sumSale1Year;
    @Field(type = FieldType.Keyword)
    private String sumSale180Days;
    @Field(type = FieldType.Keyword)
    private String paymentTimeSpeed;
    @Field(type = FieldType.Keyword)
    private String purchaseTimesQuarter;
    @Field(type = FieldType.Keyword)
    private String purchaseTimesMonth;
    @Field(type = FieldType.Keyword)
    private String purchaseTimes30Days;
    @Field(type = FieldType.Keyword)
    private String purchaseTimes90Days;
    @Field(type = FieldType.Keyword)
    private String purchaseTimes365Days;
    @Field(type = FieldType.Keyword)
    private String purchaseTimesQuarterLabel;
    @Field(type = FieldType.Keyword)
    private String purchaseTimesMonthLabel;
    @Field(type = FieldType.Keyword)
    private String purchaseTimes30DaysLabel;
    @Field(type = FieldType.Keyword)
    private String purchaseTimes90DaysLabel;
    @Field(type = FieldType.Keyword)
    private String purchaseTimes365DaysLabel;
    @Field(type = FieldType.Keyword)
    private String meanSale1Year;
    @Field(type = FieldType.Keyword)
    private String meanTurnoverQuarter;
    @Field(type = FieldType.Keyword)
    private String meanTurnoverMonth;
    @Field(type = FieldType.Keyword)
    private String meanTurnover30Days;
    @Field(type = FieldType.Keyword)
    private String meanTurnover90Days;
    @Field(type = FieldType.Keyword)
    private String meanTurnover365Days;
    @Field(type = FieldType.Keyword)
    private String meanTurnoverQuarterLabel;
    @Field(type = FieldType.Keyword)
    private String meanTurnoverMonthLabel;
    @Field(type = FieldType.Keyword)
    private String meanTurnover30DaysLabel;
    @Field(type = FieldType.Keyword)
    private String meanTurnover90DaysLabel;
    @Field(type = FieldType.Keyword)
    private String meanTurnover365DaysLabel;
    @Field(type = FieldType.Keyword)
    private String consumptionCap;
    @Field(type = FieldType.Keyword)
    private String activityCycleLengthways;
    @Field(type = FieldType.Keyword)
    private String userLoyalty;
    @Field(type = FieldType.Keyword)
    private String activityCycleCrosswise;
    @Field(type = FieldType.Keyword)
    private String histItemListLvl1;
    @Field(type = FieldType.Keyword)
    private String histItemListLvl2;
    @Field(type = FieldType.Keyword)
    private String histItemListLvl3;
    @Field(type = FieldType.Keyword)
    private String histItemListLvl4;
    @Field(type = FieldType.Keyword)
    private String histItemIdListLvl1;
    @Field(type = FieldType.Keyword)
    private String histItemIdListLvl2;
    @Field(type = FieldType.Keyword)
    private String histItemIdListLvl3;
    @Field(type = FieldType.Keyword)
    private String histItemIdListLvl4;
    @Field(type = FieldType.Keyword)
    private String histItemCidListLvl1;
    @Field(type = FieldType.Keyword)
    private String histItemCidListLvl2;
    @Field(type = FieldType.Keyword)
    private String histItemCidListLvl3;
    @Field(type = FieldType.Keyword)
    private String histItemCidListLvl4;
    @Field(type = FieldType.Keyword)
    private String itemLvl4CateCnt;
    @Field(type = FieldType.Keyword)
    private String itemLvl3CateCnt;
    @Field(type = FieldType.Keyword)
    private String itemLvl2CateCnt;
    @Field(type = FieldType.Keyword)
    private String itemLvl1CateCnt;
    private String itemRecommend;
    private String lvl1Cnt365Top3;
    private String lvl2Cnt365Top3;
    private String lvl3Cnt365Top3;
    private String lvl4Cnt365Top3;
    private String lvl1Cnt90Top3;
    private String lvl2Cnt90Top3;
    private String lvl3Cnt90Top3;
    private String lvl4Cnt90Top3;
    private String lvl1Amount365Top3;
    private String lvl2Amount365Top3;
    private String lvl3Amount365Top3;
    private String lvl4Amount365Top3;
    private String lvl1Amount90Top3;
    private String lvl2Amount90Top3;
    private String lvl3Amount90Top3;
    private String lvl4Amount90Top3;
    private String lvl1Amount30Top3;
    private String lvl2Amount30Top3;
    private String lvl3Amount30Top3;
    private String lvl4Amount30Top3;
    private String lvl1CntQuarterTop3;
    private String lvl2CntQuarterTop3;
    private String lvl3CntQuarterTop3;
    private String lvl4CntQuarterTop3;
    private String lvl1AmountQuarterTop3;
    private String lvl2AmountQuarterTop3;
    private String lvl3AmountQuarterTop3;
    private String lvl4AmountQuarterTop3;
    private String lvl1CntMonthTop3;
    private String lvl2CntMonthTop3;
    private String lvl3CntMonthTop3;
    private String lvl4CntMonthTop3;
    private String lvl1AmountMonthTop3;
    private String lvl2AmountMonthTop3;
    private String lvl3AmountMonthTop3;
    private String lvl4AmountMonthTop3;
    @Field(type = FieldType.Keyword)
    private String nickname;
    @Field(type = FieldType.Keyword)
    private String mobile;
    @Field(type = FieldType.Keyword)
    private String date;

    @Override
    public String toString() {
        return "DwsLabelDO{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", memberId='" + memberId + '\'' +
                ", shopId='" + shopId + '\'' +
                ", year='" + year + '\'' +
                ", quarter='" + quarter + '\'' +
                ", month='" + month + '\'' +
                ", sex='" + sex + '\'' +
                ", cityLevel='" + cityLevel + '\'' +
                ", isHaveBaby='" + isHaveBaby + '\'' +
                ", isHavePet='" + isHavePet + '\'' +
                ", receivingAddressProvince='" + receivingAddressProvince + '\'' +
                ", receivingAddressCity='" + receivingAddressCity + '\'' +
                ", receivingAddressDistrict='" + receivingAddressDistrict + '\'' +
                ", receivingAddressStreet='" + receivingAddressStreet + '\'' +
                ", receivingAddressCommunity='" + receivingAddressCommunity + '\'' +
                ", shoppingTime='" + shoppingTime + '\'' +
                ", shoppingTimePoint='" + shoppingTimePoint + '\'' +
                ", preferenceOfPromotion='" + preferenceOfPromotion + '\'' +
                ", platformList='" + platformList + '\'' +
                ", preferenceOfPlatform='" + preferenceOfPlatform + '\'' +
                ", preferenceOfTransactionType='" + preferenceOfTransactionType + '\'' +
                ", lastPurchaseTime='" + lastPurchaseTime + '\'' +
                ", lastPurchaseTimeLabel='" + lastPurchaseTimeLabel + '\'' +
                ", rfmModelResult='" + rfmModelResult + '\'' +
                ", distanceEarliestToday='" + distanceEarliestToday + '\'' +
                ", daysMeanBuyNum='" + daysMeanBuyNum + '\'' +
                ", daysMeanBuy='" + daysMeanBuy + '\'' +
                ", numPerShopPrefer='" + numPerShopPrefer + '\'' +
                ", itemCount1Year='" + itemCount1Year + '\'' +
                ", intervalDays1Year='" + intervalDays1Year + '\'' +
                ", sumSaleMonth='" + sumSaleMonth + '\'' +
                ", sumSaleQuarter='" + sumSaleQuarter + '\'' +
                ", sumSale30Days='" + sumSale30Days + '\'' +
                ", sumSale90Days='" + sumSale90Days + '\'' +
                ", sumSale1Year='" + sumSale1Year + '\'' +
                ", sumSale180Days='" + sumSale180Days + '\'' +
                ", paymentTimeSpeed='" + paymentTimeSpeed + '\'' +
                ", purchaseTimesQuarter='" + purchaseTimesQuarter + '\'' +
                ", purchaseTimesMonth='" + purchaseTimesMonth + '\'' +
                ", purchaseTimes30Days='" + purchaseTimes30Days + '\'' +
                ", purchaseTimes90Days='" + purchaseTimes90Days + '\'' +
                ", purchaseTimes365Days='" + purchaseTimes365Days + '\'' +
                ", purchaseTimesQuarterLabel='" + purchaseTimesQuarterLabel + '\'' +
                ", purchaseTimesMonthLabel='" + purchaseTimesMonthLabel + '\'' +
                ", purchaseTimes30DaysLabel='" + purchaseTimes30DaysLabel + '\'' +
                ", purchaseTimes90DaysLabel='" + purchaseTimes90DaysLabel + '\'' +
                ", purchaseTimes365DaysLabel='" + purchaseTimes365DaysLabel + '\'' +
                ", meanSale1Year='" + meanSale1Year + '\'' +
                ", meanTurnoverQuarter='" + meanTurnoverQuarter + '\'' +
                ", meanTurnoverMonth='" + meanTurnoverMonth + '\'' +
                ", meanTurnover30Days='" + meanTurnover30Days + '\'' +
                ", meanTurnover90Days='" + meanTurnover90Days + '\'' +
                ", meanTurnover365Days='" + meanTurnover365Days + '\'' +
                ", meanTurnoverQuarterLabel='" + meanTurnoverQuarterLabel + '\'' +
                ", meanTurnoverMonthLabel='" + meanTurnoverMonthLabel + '\'' +
                ", meanTurnover30DaysLabel='" + meanTurnover30DaysLabel + '\'' +
                ", meanTurnover90DaysLabel='" + meanTurnover90DaysLabel + '\'' +
                ", meanTurnover365DaysLabel='" + meanTurnover365DaysLabel + '\'' +
                ", consumptionCap='" + consumptionCap + '\'' +
                ", activityCycleLengthways='" + activityCycleLengthways + '\'' +
                ", userLoyalty='" + userLoyalty + '\'' +
                ", activityCycleCrosswise='" + activityCycleCrosswise + '\'' +
                ", histItemListLvl1='" + histItemListLvl1 + '\'' +
                ", histItemListLvl2='" + histItemListLvl2 + '\'' +
                ", histItemListLvl3='" + histItemListLvl3 + '\'' +
                ", histItemListLvl4='" + histItemListLvl4 + '\'' +
                ", histItemIdListLvl1='" + histItemIdListLvl1 + '\'' +
                ", histItemIdListLvl2='" + histItemIdListLvl2 + '\'' +
                ", histItemIdListLvl3='" + histItemIdListLvl3 + '\'' +
                ", histItemIdListLvl4='" + histItemIdListLvl4 + '\'' +
                ", histItemCidListLvl1='" + histItemCidListLvl1 + '\'' +
                ", histItemCidListLvl2='" + histItemCidListLvl2 + '\'' +
                ", histItemCidListLvl3='" + histItemCidListLvl3 + '\'' +
                ", histItemCidListLvl4='" + histItemCidListLvl4 + '\'' +
                ", itemLvl4CateCnt='" + itemLvl4CateCnt + '\'' +
                ", itemLvl3CateCnt='" + itemLvl3CateCnt + '\'' +
                ", itemLvl2CateCnt='" + itemLvl2CateCnt + '\'' +
                ", itemLvl1CateCnt='" + itemLvl1CateCnt + '\'' +
                ", itemRecommend='" + itemRecommend + '\'' +
                ", lvl1Cnt365Top3='" + lvl1Cnt365Top3 + '\'' +
                ", lvl2Cnt365Top3='" + lvl2Cnt365Top3 + '\'' +
                ", lvl3Cnt365Top3='" + lvl3Cnt365Top3 + '\'' +
                ", lvl4Cnt365Top3='" + lvl4Cnt365Top3 + '\'' +
                ", lvl1Cnt90Top3='" + lvl1Cnt90Top3 + '\'' +
                ", lvl2Cnt90Top3='" + lvl2Cnt90Top3 + '\'' +
                ", lvl3Cnt90Top3='" + lvl3Cnt90Top3 + '\'' +
                ", lvl4Cnt90Top3='" + lvl4Cnt90Top3 + '\'' +
                ", lvl1Amount365Top3='" + lvl1Amount365Top3 + '\'' +
                ", lvl2Amount365Top3='" + lvl2Amount365Top3 + '\'' +
                ", lvl3Amount365Top3='" + lvl3Amount365Top3 + '\'' +
                ", lvl4Amount365Top3='" + lvl4Amount365Top3 + '\'' +
                ", lvl1Amount90Top3='" + lvl1Amount90Top3 + '\'' +
                ", lvl2Amount90Top3='" + lvl2Amount90Top3 + '\'' +
                ", lvl3Amount90Top3='" + lvl3Amount90Top3 + '\'' +
                ", lvl4Amount90Top3='" + lvl4Amount90Top3 + '\'' +
                ", lvl1Amount30Top3='" + lvl1Amount30Top3 + '\'' +
                ", lvl2Amount30Top3='" + lvl2Amount30Top3 + '\'' +
                ", lvl3Amount30Top3='" + lvl3Amount30Top3 + '\'' +
                ", lvl4Amount30Top3='" + lvl4Amount30Top3 + '\'' +
                ", lvl1CntQuarterTop3='" + lvl1CntQuarterTop3 + '\'' +
                ", lvl2CntQuarterTop3='" + lvl2CntQuarterTop3 + '\'' +
                ", lvl3CntQuarterTop3='" + lvl3CntQuarterTop3 + '\'' +
                ", lvl4CntQuarterTop3='" + lvl4CntQuarterTop3 + '\'' +
                ", lvl1AmountQuarterTop3='" + lvl1AmountQuarterTop3 + '\'' +
                ", lvl2AmountQuarterTop3='" + lvl2AmountQuarterTop3 + '\'' +
                ", lvl3AmountQuarterTop3='" + lvl3AmountQuarterTop3 + '\'' +
                ", lvl4AmountQuarterTop3='" + lvl4AmountQuarterTop3 + '\'' +
                ", lvl1CntMonthTop3='" + lvl1CntMonthTop3 + '\'' +
                ", lvl2CntMonthTop3='" + lvl2CntMonthTop3 + '\'' +
                ", lvl3CntMonthTop3='" + lvl3CntMonthTop3 + '\'' +
                ", lvl4CntMonthTop3='" + lvl4CntMonthTop3 + '\'' +
                ", lvl1AmountMonthTop3='" + lvl1AmountMonthTop3 + '\'' +
                ", lvl2AmountMonthTop3='" + lvl2AmountMonthTop3 + '\'' +
                ", lvl3AmountMonthTop3='" + lvl3AmountMonthTop3 + '\'' +
                ", lvl4AmountMonthTop3='" + lvl4AmountMonthTop3 + '\'' +
                ", nickname='" + nickname + '\'' +
                ", mobile='" + mobile + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCityLevel() {
        return cityLevel;
    }

    public void setCityLevel(String cityLevel) {
        this.cityLevel = cityLevel;
    }

    public String getIsHaveBaby() {
        return isHaveBaby;
    }

    public void setIsHaveBaby(String isHaveBaby) {
        this.isHaveBaby = isHaveBaby;
    }

    public String getIsHavePet() {
        return isHavePet;
    }

    public void setIsHavePet(String isHavePet) {
        this.isHavePet = isHavePet;
    }

    public String getReceivingAddressProvince() {
        return receivingAddressProvince;
    }

    public void setReceivingAddressProvince(String receivingAddressProvince) {
        this.receivingAddressProvince = receivingAddressProvince;
    }

    public String getReceivingAddressCity() {
        return receivingAddressCity;
    }

    public void setReceivingAddressCity(String receivingAddressCity) {
        this.receivingAddressCity = receivingAddressCity;
    }

    public String getReceivingAddressDistrict() {
        return receivingAddressDistrict;
    }

    public void setReceivingAddressDistrict(String receivingAddressDistrict) {
        this.receivingAddressDistrict = receivingAddressDistrict;
    }

    public String getReceivingAddressStreet() {
        return receivingAddressStreet;
    }

    public void setReceivingAddressStreet(String receivingAddressStreet) {
        this.receivingAddressStreet = receivingAddressStreet;
    }

    public String getReceivingAddressCommunity() {
        return receivingAddressCommunity;
    }

    public void setReceivingAddressCommunity(String receivingAddressCommunity) {
        this.receivingAddressCommunity = receivingAddressCommunity;
    }

    public String getShoppingTime() {
        return shoppingTime;
    }

    public void setShoppingTime(String shoppingTime) {
        this.shoppingTime = shoppingTime;
    }

    public String getShoppingTimePoint() {
        return shoppingTimePoint;
    }

    public void setShoppingTimePoint(String shoppingTimePoint) {
        this.shoppingTimePoint = shoppingTimePoint;
    }

    public String getPreferenceOfPromotion() {
        return preferenceOfPromotion;
    }

    public void setPreferenceOfPromotion(String preferenceOfPromotion) {
        this.preferenceOfPromotion = preferenceOfPromotion;
    }

    public String getPlatformList() {
        return platformList;
    }

    public void setPlatformList(String platformList) {
        this.platformList = platformList;
    }

    public String getPreferenceOfPlatform() {
        return preferenceOfPlatform;
    }

    public void setPreferenceOfPlatform(String preferenceOfPlatform) {
        this.preferenceOfPlatform = preferenceOfPlatform;
    }

    public String getPreferenceOfTransactionType() {
        return preferenceOfTransactionType;
    }

    public void setPreferenceOfTransactionType(String preferenceOfTransactionType) {
        this.preferenceOfTransactionType = preferenceOfTransactionType;
    }

    public String getLastPurchaseTime() {
        return lastPurchaseTime;
    }

    public void setLastPurchaseTime(String lastPurchaseTime) {
        this.lastPurchaseTime = lastPurchaseTime;
    }

    public String getLastPurchaseTimeLabel() {
        return lastPurchaseTimeLabel;
    }

    public void setLastPurchaseTimeLabel(String lastPurchaseTimeLabel) {
        this.lastPurchaseTimeLabel = lastPurchaseTimeLabel;
    }

    public String getRfmModelResult() {
        return rfmModelResult;
    }

    public void setRfmModelResult(String rfmModelResult) {
        this.rfmModelResult = rfmModelResult;
    }

    public String getDistanceEarliestToday() {
        return distanceEarliestToday;
    }

    public void setDistanceEarliestToday(String distanceEarliestToday) {
        this.distanceEarliestToday = distanceEarliestToday;
    }

    public String getDaysMeanBuyNum() {
        return daysMeanBuyNum;
    }

    public void setDaysMeanBuyNum(String daysMeanBuyNum) {
        this.daysMeanBuyNum = daysMeanBuyNum;
    }

    public String getDaysMeanBuy() {
        return daysMeanBuy;
    }

    public void setDaysMeanBuy(String daysMeanBuy) {
        this.daysMeanBuy = daysMeanBuy;
    }

    public String getNumPerShopPrefer() {
        return numPerShopPrefer;
    }

    public void setNumPerShopPrefer(String numPerShopPrefer) {
        this.numPerShopPrefer = numPerShopPrefer;
    }

    public String getItemCount1Year() {
        return itemCount1Year;
    }

    public void setItemCount1Year(String itemCount1Year) {
        this.itemCount1Year = itemCount1Year;
    }

    public String getIntervalDays1Year() {
        return intervalDays1Year;
    }

    public void setIntervalDays1Year(String intervalDays1Year) {
        this.intervalDays1Year = intervalDays1Year;
    }

    public String getSumSaleMonth() {
        return sumSaleMonth;
    }

    public void setSumSaleMonth(String sumSaleMonth) {
        this.sumSaleMonth = sumSaleMonth;
    }

    public String getSumSaleQuarter() {
        return sumSaleQuarter;
    }

    public void setSumSaleQuarter(String sumSaleQuarter) {
        this.sumSaleQuarter = sumSaleQuarter;
    }

    public String getSumSale30Days() {
        return sumSale30Days;
    }

    public void setSumSale30Days(String sumSale30Days) {
        this.sumSale30Days = sumSale30Days;
    }

    public String getSumSale90Days() {
        return sumSale90Days;
    }

    public void setSumSale90Days(String sumSale90Days) {
        this.sumSale90Days = sumSale90Days;
    }

    public String getSumSale1Year() {
        return sumSale1Year;
    }

    public void setSumSale1Year(String sumSale1Year) {
        this.sumSale1Year = sumSale1Year;
    }

    public String getSumSale180Days() {
        return sumSale180Days;
    }

    public void setSumSale180Days(String sumSale180Days) {
        this.sumSale180Days = sumSale180Days;
    }

    public String getPaymentTimeSpeed() {
        return paymentTimeSpeed;
    }

    public void setPaymentTimeSpeed(String paymentTimeSpeed) {
        this.paymentTimeSpeed = paymentTimeSpeed;
    }

    public String getPurchaseTimesQuarter() {
        return purchaseTimesQuarter;
    }

    public void setPurchaseTimesQuarter(String purchaseTimesQuarter) {
        this.purchaseTimesQuarter = purchaseTimesQuarter;
    }

    public String getPurchaseTimesMonth() {
        return purchaseTimesMonth;
    }

    public void setPurchaseTimesMonth(String purchaseTimesMonth) {
        this.purchaseTimesMonth = purchaseTimesMonth;
    }

    public String getPurchaseTimes30Days() {
        return purchaseTimes30Days;
    }

    public void setPurchaseTimes30Days(String purchaseTimes30Days) {
        this.purchaseTimes30Days = purchaseTimes30Days;
    }

    public String getPurchaseTimes90Days() {
        return purchaseTimes90Days;
    }

    public void setPurchaseTimes90Days(String purchaseTimes90Days) {
        this.purchaseTimes90Days = purchaseTimes90Days;
    }

    public String getPurchaseTimes365Days() {
        return purchaseTimes365Days;
    }

    public void setPurchaseTimes365Days(String purchaseTimes365Days) {
        this.purchaseTimes365Days = purchaseTimes365Days;
    }

    public String getPurchaseTimesQuarterLabel() {
        return purchaseTimesQuarterLabel;
    }

    public void setPurchaseTimesQuarterLabel(String purchaseTimesQuarterLabel) {
        this.purchaseTimesQuarterLabel = purchaseTimesQuarterLabel;
    }

    public String getPurchaseTimesMonthLabel() {
        return purchaseTimesMonthLabel;
    }

    public void setPurchaseTimesMonthLabel(String purchaseTimesMonthLabel) {
        this.purchaseTimesMonthLabel = purchaseTimesMonthLabel;
    }

    public String getPurchaseTimes30DaysLabel() {
        return purchaseTimes30DaysLabel;
    }

    public void setPurchaseTimes30DaysLabel(String purchaseTimes30DaysLabel) {
        this.purchaseTimes30DaysLabel = purchaseTimes30DaysLabel;
    }

    public String getPurchaseTimes90DaysLabel() {
        return purchaseTimes90DaysLabel;
    }

    public void setPurchaseTimes90DaysLabel(String purchaseTimes90DaysLabel) {
        this.purchaseTimes90DaysLabel = purchaseTimes90DaysLabel;
    }

    public String getPurchaseTimes365DaysLabel() {
        return purchaseTimes365DaysLabel;
    }

    public void setPurchaseTimes365DaysLabel(String purchaseTimes365DaysLabel) {
        this.purchaseTimes365DaysLabel = purchaseTimes365DaysLabel;
    }

    public String getMeanSale1Year() {
        return meanSale1Year;
    }

    public void setMeanSale1Year(String meanSale1Year) {
        this.meanSale1Year = meanSale1Year;
    }

    public String getMeanTurnoverQuarter() {
        return meanTurnoverQuarter;
    }

    public void setMeanTurnoverQuarter(String meanTurnoverQuarter) {
        this.meanTurnoverQuarter = meanTurnoverQuarter;
    }

    public String getMeanTurnoverMonth() {
        return meanTurnoverMonth;
    }

    public void setMeanTurnoverMonth(String meanTurnoverMonth) {
        this.meanTurnoverMonth = meanTurnoverMonth;
    }

    public String getMeanTurnover30Days() {
        return meanTurnover30Days;
    }

    public void setMeanTurnover30Days(String meanTurnover30Days) {
        this.meanTurnover30Days = meanTurnover30Days;
    }

    public String getMeanTurnover90Days() {
        return meanTurnover90Days;
    }

    public void setMeanTurnover90Days(String meanTurnover90Days) {
        this.meanTurnover90Days = meanTurnover90Days;
    }

    public String getMeanTurnover365Days() {
        return meanTurnover365Days;
    }

    public void setMeanTurnover365Days(String meanTurnover365Days) {
        this.meanTurnover365Days = meanTurnover365Days;
    }

    public String getMeanTurnoverQuarterLabel() {
        return meanTurnoverQuarterLabel;
    }

    public void setMeanTurnoverQuarterLabel(String meanTurnoverQuarterLabel) {
        this.meanTurnoverQuarterLabel = meanTurnoverQuarterLabel;
    }

    public String getMeanTurnoverMonthLabel() {
        return meanTurnoverMonthLabel;
    }

    public void setMeanTurnoverMonthLabel(String meanTurnoverMonthLabel) {
        this.meanTurnoverMonthLabel = meanTurnoverMonthLabel;
    }

    public String getMeanTurnover30DaysLabel() {
        return meanTurnover30DaysLabel;
    }

    public void setMeanTurnover30DaysLabel(String meanTurnover30DaysLabel) {
        this.meanTurnover30DaysLabel = meanTurnover30DaysLabel;
    }

    public String getMeanTurnover90DaysLabel() {
        return meanTurnover90DaysLabel;
    }

    public void setMeanTurnover90DaysLabel(String meanTurnover90DaysLabel) {
        this.meanTurnover90DaysLabel = meanTurnover90DaysLabel;
    }

    public String getMeanTurnover365DaysLabel() {
        return meanTurnover365DaysLabel;
    }

    public void setMeanTurnover365DaysLabel(String meanTurnover365DaysLabel) {
        this.meanTurnover365DaysLabel = meanTurnover365DaysLabel;
    }

    public String getConsumptionCap() {
        return consumptionCap;
    }

    public void setConsumptionCap(String consumptionCap) {
        this.consumptionCap = consumptionCap;
    }

    public String getActivityCycleLengthways() {
        return activityCycleLengthways;
    }

    public void setActivityCycleLengthways(String activityCycleLengthways) {
        this.activityCycleLengthways = activityCycleLengthways;
    }

    public String getUserLoyalty() {
        return userLoyalty;
    }

    public void setUserLoyalty(String userLoyalty) {
        this.userLoyalty = userLoyalty;
    }

    public String getActivityCycleCrosswise() {
        return activityCycleCrosswise;
    }

    public void setActivityCycleCrosswise(String activityCycleCrosswise) {
        this.activityCycleCrosswise = activityCycleCrosswise;
    }

    public String getHistItemListLvl1() {
        return histItemListLvl1;
    }

    public void setHistItemListLvl1(String histItemListLvl1) {
        this.histItemListLvl1 = histItemListLvl1;
    }

    public String getHistItemListLvl2() {
        return histItemListLvl2;
    }

    public void setHistItemListLvl2(String histItemListLvl2) {
        this.histItemListLvl2 = histItemListLvl2;
    }

    public String getHistItemListLvl3() {
        return histItemListLvl3;
    }

    public void setHistItemListLvl3(String histItemListLvl3) {
        this.histItemListLvl3 = histItemListLvl3;
    }

    public String getHistItemListLvl4() {
        return histItemListLvl4;
    }

    public void setHistItemListLvl4(String histItemListLvl4) {
        this.histItemListLvl4 = histItemListLvl4;
    }

    public String getHistItemIdListLvl1() {
        return histItemIdListLvl1;
    }

    public void setHistItemIdListLvl1(String histItemIdListLvl1) {
        this.histItemIdListLvl1 = histItemIdListLvl1;
    }

    public String getHistItemIdListLvl2() {
        return histItemIdListLvl2;
    }

    public void setHistItemIdListLvl2(String histItemIdListLvl2) {
        this.histItemIdListLvl2 = histItemIdListLvl2;
    }

    public String getHistItemIdListLvl3() {
        return histItemIdListLvl3;
    }

    public void setHistItemIdListLvl3(String histItemIdListLvl3) {
        this.histItemIdListLvl3 = histItemIdListLvl3;
    }

    public String getHistItemIdListLvl4() {
        return histItemIdListLvl4;
    }

    public void setHistItemIdListLvl4(String histItemIdListLvl4) {
        this.histItemIdListLvl4 = histItemIdListLvl4;
    }

    public String getHistItemCidListLvl1() {
        return histItemCidListLvl1;
    }

    public void setHistItemCidListLvl1(String histItemCidListLvl1) {
        this.histItemCidListLvl1 = histItemCidListLvl1;
    }

    public String getHistItemCidListLvl2() {
        return histItemCidListLvl2;
    }

    public void setHistItemCidListLvl2(String histItemCidListLvl2) {
        this.histItemCidListLvl2 = histItemCidListLvl2;
    }

    public String getHistItemCidListLvl3() {
        return histItemCidListLvl3;
    }

    public void setHistItemCidListLvl3(String histItemCidListLvl3) {
        this.histItemCidListLvl3 = histItemCidListLvl3;
    }

    public String getHistItemCidListLvl4() {
        return histItemCidListLvl4;
    }

    public void setHistItemCidListLvl4(String histItemCidListLvl4) {
        this.histItemCidListLvl4 = histItemCidListLvl4;
    }

    public String getItemLvl4CateCnt() {
        return itemLvl4CateCnt;
    }

    public void setItemLvl4CateCnt(String itemLvl4CateCnt) {
        this.itemLvl4CateCnt = itemLvl4CateCnt;
    }

    public String getItemLvl3CateCnt() {
        return itemLvl3CateCnt;
    }

    public void setItemLvl3CateCnt(String itemLvl3CateCnt) {
        this.itemLvl3CateCnt = itemLvl3CateCnt;
    }

    public String getItemLvl2CateCnt() {
        return itemLvl2CateCnt;
    }

    public void setItemLvl2CateCnt(String itemLvl2CateCnt) {
        this.itemLvl2CateCnt = itemLvl2CateCnt;
    }

    public String getItemLvl1CateCnt() {
        return itemLvl1CateCnt;
    }

    public void setItemLvl1CateCnt(String itemLvl1CateCnt) {
        this.itemLvl1CateCnt = itemLvl1CateCnt;
    }

    public String getItemRecommend() {
        return itemRecommend;
    }

    public void setItemRecommend(String itemRecommend) {
        this.itemRecommend = itemRecommend;
    }

    public String getLvl1Cnt365Top3() {
        return lvl1Cnt365Top3;
    }

    public void setLvl1Cnt365Top3(String lvl1Cnt365Top3) {
        this.lvl1Cnt365Top3 = lvl1Cnt365Top3;
    }

    public String getLvl2Cnt365Top3() {
        return lvl2Cnt365Top3;
    }

    public void setLvl2Cnt365Top3(String lvl2Cnt365Top3) {
        this.lvl2Cnt365Top3 = lvl2Cnt365Top3;
    }

    public String getLvl3Cnt365Top3() {
        return lvl3Cnt365Top3;
    }

    public void setLvl3Cnt365Top3(String lvl3Cnt365Top3) {
        this.lvl3Cnt365Top3 = lvl3Cnt365Top3;
    }

    public String getLvl4Cnt365Top3() {
        return lvl4Cnt365Top3;
    }

    public void setLvl4Cnt365Top3(String lvl4Cnt365Top3) {
        this.lvl4Cnt365Top3 = lvl4Cnt365Top3;
    }

    public String getLvl1Cnt90Top3() {
        return lvl1Cnt90Top3;
    }

    public void setLvl1Cnt90Top3(String lvl1Cnt90Top3) {
        this.lvl1Cnt90Top3 = lvl1Cnt90Top3;
    }

    public String getLvl2Cnt90Top3() {
        return lvl2Cnt90Top3;
    }

    public void setLvl2Cnt90Top3(String lvl2Cnt90Top3) {
        this.lvl2Cnt90Top3 = lvl2Cnt90Top3;
    }

    public String getLvl3Cnt90Top3() {
        return lvl3Cnt90Top3;
    }

    public void setLvl3Cnt90Top3(String lvl3Cnt90Top3) {
        this.lvl3Cnt90Top3 = lvl3Cnt90Top3;
    }

    public String getLvl4Cnt90Top3() {
        return lvl4Cnt90Top3;
    }

    public void setLvl4Cnt90Top3(String lvl4Cnt90Top3) {
        this.lvl4Cnt90Top3 = lvl4Cnt90Top3;
    }

    public String getLvl1Amount365Top3() {
        return lvl1Amount365Top3;
    }

    public void setLvl1Amount365Top3(String lvl1Amount365Top3) {
        this.lvl1Amount365Top3 = lvl1Amount365Top3;
    }

    public String getLvl2Amount365Top3() {
        return lvl2Amount365Top3;
    }

    public void setLvl2Amount365Top3(String lvl2Amount365Top3) {
        this.lvl2Amount365Top3 = lvl2Amount365Top3;
    }

    public String getLvl3Amount365Top3() {
        return lvl3Amount365Top3;
    }

    public void setLvl3Amount365Top3(String lvl3Amount365Top3) {
        this.lvl3Amount365Top3 = lvl3Amount365Top3;
    }

    public String getLvl4Amount365Top3() {
        return lvl4Amount365Top3;
    }

    public void setLvl4Amount365Top3(String lvl4Amount365Top3) {
        this.lvl4Amount365Top3 = lvl4Amount365Top3;
    }

    public String getLvl1Amount90Top3() {
        return lvl1Amount90Top3;
    }

    public void setLvl1Amount90Top3(String lvl1Amount90Top3) {
        this.lvl1Amount90Top3 = lvl1Amount90Top3;
    }

    public String getLvl2Amount90Top3() {
        return lvl2Amount90Top3;
    }

    public void setLvl2Amount90Top3(String lvl2Amount90Top3) {
        this.lvl2Amount90Top3 = lvl2Amount90Top3;
    }

    public String getLvl3Amount90Top3() {
        return lvl3Amount90Top3;
    }

    public void setLvl3Amount90Top3(String lvl3Amount90Top3) {
        this.lvl3Amount90Top3 = lvl3Amount90Top3;
    }

    public String getLvl4Amount90Top3() {
        return lvl4Amount90Top3;
    }

    public void setLvl4Amount90Top3(String lvl4Amount90Top3) {
        this.lvl4Amount90Top3 = lvl4Amount90Top3;
    }

    public String getLvl1Amount30Top3() {
        return lvl1Amount30Top3;
    }

    public void setLvl1Amount30Top3(String lvl1Amount30Top3) {
        this.lvl1Amount30Top3 = lvl1Amount30Top3;
    }

    public String getLvl2Amount30Top3() {
        return lvl2Amount30Top3;
    }

    public void setLvl2Amount30Top3(String lvl2Amount30Top3) {
        this.lvl2Amount30Top3 = lvl2Amount30Top3;
    }

    public String getLvl3Amount30Top3() {
        return lvl3Amount30Top3;
    }

    public void setLvl3Amount30Top3(String lvl3Amount30Top3) {
        this.lvl3Amount30Top3 = lvl3Amount30Top3;
    }

    public String getLvl4Amount30Top3() {
        return lvl4Amount30Top3;
    }

    public void setLvl4Amount30Top3(String lvl4Amount30Top3) {
        this.lvl4Amount30Top3 = lvl4Amount30Top3;
    }

    public String getLvl1CntQuarterTop3() {
        return lvl1CntQuarterTop3;
    }

    public void setLvl1CntQuarterTop3(String lvl1CntQuarterTop3) {
        this.lvl1CntQuarterTop3 = lvl1CntQuarterTop3;
    }

    public String getLvl2CntQuarterTop3() {
        return lvl2CntQuarterTop3;
    }

    public void setLvl2CntQuarterTop3(String lvl2CntQuarterTop3) {
        this.lvl2CntQuarterTop3 = lvl2CntQuarterTop3;
    }

    public String getLvl3CntQuarterTop3() {
        return lvl3CntQuarterTop3;
    }

    public void setLvl3CntQuarterTop3(String lvl3CntQuarterTop3) {
        this.lvl3CntQuarterTop3 = lvl3CntQuarterTop3;
    }

    public String getLvl4CntQuarterTop3() {
        return lvl4CntQuarterTop3;
    }

    public void setLvl4CntQuarterTop3(String lvl4CntQuarterTop3) {
        this.lvl4CntQuarterTop3 = lvl4CntQuarterTop3;
    }

    public String getLvl1AmountQuarterTop3() {
        return lvl1AmountQuarterTop3;
    }

    public void setLvl1AmountQuarterTop3(String lvl1AmountQuarterTop3) {
        this.lvl1AmountQuarterTop3 = lvl1AmountQuarterTop3;
    }

    public String getLvl2AmountQuarterTop3() {
        return lvl2AmountQuarterTop3;
    }

    public void setLvl2AmountQuarterTop3(String lvl2AmountQuarterTop3) {
        this.lvl2AmountQuarterTop3 = lvl2AmountQuarterTop3;
    }

    public String getLvl3AmountQuarterTop3() {
        return lvl3AmountQuarterTop3;
    }

    public void setLvl3AmountQuarterTop3(String lvl3AmountQuarterTop3) {
        this.lvl3AmountQuarterTop3 = lvl3AmountQuarterTop3;
    }

    public String getLvl4AmountQuarterTop3() {
        return lvl4AmountQuarterTop3;
    }

    public void setLvl4AmountQuarterTop3(String lvl4AmountQuarterTop3) {
        this.lvl4AmountQuarterTop3 = lvl4AmountQuarterTop3;
    }

    public String getLvl1CntMonthTop3() {
        return lvl1CntMonthTop3;
    }

    public void setLvl1CntMonthTop3(String lvl1CntMonthTop3) {
        this.lvl1CntMonthTop3 = lvl1CntMonthTop3;
    }

    public String getLvl2CntMonthTop3() {
        return lvl2CntMonthTop3;
    }

    public void setLvl2CntMonthTop3(String lvl2CntMonthTop3) {
        this.lvl2CntMonthTop3 = lvl2CntMonthTop3;
    }

    public String getLvl3CntMonthTop3() {
        return lvl3CntMonthTop3;
    }

    public void setLvl3CntMonthTop3(String lvl3CntMonthTop3) {
        this.lvl3CntMonthTop3 = lvl3CntMonthTop3;
    }

    public String getLvl4CntMonthTop3() {
        return lvl4CntMonthTop3;
    }

    public void setLvl4CntMonthTop3(String lvl4CntMonthTop3) {
        this.lvl4CntMonthTop3 = lvl4CntMonthTop3;
    }

    public String getLvl1AmountMonthTop3() {
        return lvl1AmountMonthTop3;
    }

    public void setLvl1AmountMonthTop3(String lvl1AmountMonthTop3) {
        this.lvl1AmountMonthTop3 = lvl1AmountMonthTop3;
    }

    public String getLvl2AmountMonthTop3() {
        return lvl2AmountMonthTop3;
    }

    public void setLvl2AmountMonthTop3(String lvl2AmountMonthTop3) {
        this.lvl2AmountMonthTop3 = lvl2AmountMonthTop3;
    }

    public String getLvl3AmountMonthTop3() {
        return lvl3AmountMonthTop3;
    }

    public void setLvl3AmountMonthTop3(String lvl3AmountMonthTop3) {
        this.lvl3AmountMonthTop3 = lvl3AmountMonthTop3;
    }

    public String getLvl4AmountMonthTop3() {
        return lvl4AmountMonthTop3;
    }

    public void setLvl4AmountMonthTop3(String lvl4AmountMonthTop3) {
        this.lvl4AmountMonthTop3 = lvl4AmountMonthTop3;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}