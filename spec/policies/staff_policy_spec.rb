require 'rails_helper'

describe StaffPolicy do
  subject { StaffPolicy }
  let(:user) { FactoryGirl.build(:user) }
  let(:admin) { FactoryGirl.build(:admin) }
  let(:staff_record) { FactoryGirl.build(:staff) }

  permissions :create?, :erstaff?, :new?, :destroy?, :admin_options? do
    it 'grants access to admin' do
      expect(subject).to permit(admin)
    end

    it 'denies access to user' do
      expect(subject).not_to permit(user)
    end
  end

  permissions :edit?, :update? do
    it 'grants access to admin' do
      expect(subject).to permit(admin)
    end

    context 'staff not signed in' do
      it 'denies access to user' do
        expect(subject).not_to permit(user)
        expect(subject).not_to permit(user, staff_record)
      end
    end

    context 'staff is signed in' do
      let(:staff_record) { FactoryGirl.build(:staff, email: user.email) }

      it 'grant access to user' do
        expect(subject).to permit(user, staff_record)
      end
    end
  end

  permissions :login_process? do
    context 'staff does not exist' do
      it 'denies access to admin' do
        expect(subject).not_to permit(admin)
      end

      it 'denies access to user' do
        expect(subject).not_to permit(user)
      end
    end

    context 'staff exists' do
      let(:staff_admin) { FactoryGirl.create(:staff, email: admin.email) }
      let(:staff_user) { FactoryGirl.create(:staff, email: user.email) }

      it 'grants access to admin' do
        expect(subject).to permit(admin, staff_admin)
      end

      it 'grants access to user' do
        expect(subject).to permit(user, staff_user)
      end
    end
  end
    # def edit?
  #   @current_user.admin? || (@current_user.email == @staff.email)
  # end
  #
  # def update?
  #   @current_user.admin? || (@current_user.email == @staff.email)
  # end
  #
  # def login_process?
  #   Staff.exists?(email: @current_user.email)
  # end
end